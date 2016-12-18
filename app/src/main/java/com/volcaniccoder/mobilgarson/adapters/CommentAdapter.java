package com.volcaniccoder.mobilgarson.adapters;


import android.content.Context;
import android.net.Uri;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.CommentModel;
import com.volcaniccoder.mobilgarson.models.OperationModel;
import com.volcaniccoder.mobilgarson.models.RestaurantModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.ViewHolder> {

    private List<CommentModel> model;

    public CommentAdapter(List<CommentModel> model){
        this.model = model;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comment, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        CommentModel commentModel = model.get(position);

        holder.commentText.setText(commentModel.getComment());
        holder.commentDateText.setText(commentModel.getCommentDate());
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.comment)
        TextView commentText;
        @BindView(R.id.commentDate)
        TextView commentDateText;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
