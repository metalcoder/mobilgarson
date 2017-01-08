package com.volcaniccoder.mobilgarson.restaurant.rating;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.MobilGarsonApp;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.adapters.CommentAdapter;
import com.volcaniccoder.mobilgarson.models.CommentModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RatingFragment extends Fragment implements IRatingView {

    @BindView(R.id.commentsRecyclerView)
    RecyclerView mRecyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    private IRatingPresenter presenter;
    private List<CommentModel> commentsList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rating, container, false);
        ButterKnife.bind(this, view);
        init();
        return view;
    }

    public void init() {
        presenter = new RatingPresenter(this, ((MobilGarsonApp) (getActivity().getApplication())));

        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        presenter.getComments();
    }

    @Override
    public void listComments(List<CommentModel> comments) {
        mAdapter = new CommentAdapter(comments);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void error() {
        Toast.makeText(getContext(), "hata", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void refreshComments() {
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.rating_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.ratingMenuComplaint:
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                final View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_comment,null);
                builder.setTitle("ŞİKAYET");
                builder.setView(v);
                ((EditText)v.findViewById(R.id.commentDialog)).setHint("Şikayetinizi buraya yazın");
                builder.setPositiveButton("Gönder", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        presenter.createComplaint(((EditText)v.findViewById(R.id.commentDialog)).getText().toString());
                    }
                });
                builder.create().show();
                return true;
            case R.id.ratingMenuRating:
                AlertDialog.Builder builderRate = new AlertDialog.Builder(getContext());
                View view1 = LayoutInflater.from(getContext()).inflate(R.layout.dialog_rate,null);
                final AppCompatRatingBar ratingBar = (AppCompatRatingBar) view1.findViewById(R.id.appCompatRatingBar);
                builderRate.setView(view1);
                builderRate.setTitle("Şimdi Puanla");
                builderRate.setPositiveButton("Puanla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "" + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
                    }
                });
                builderRate.setNegativeButton("İptal",null);
                builderRate.create().show();
                Toast.makeText(getContext(), "foodButtonRate", Toast.LENGTH_SHORT).show();
                return true;
        }
        return false;
    }

    @OnClick(R.id.fab)
    public void onClickFab(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_comment,null);
        builder.setTitle("YORUM");
        builder.setView(v);
        builder.setPositiveButton("Gönder", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                presenter.createComment(((EditText)v.findViewById(R.id.commentDialog)).getText().toString());
            }
        });

        builder.create().show();

    }

}
