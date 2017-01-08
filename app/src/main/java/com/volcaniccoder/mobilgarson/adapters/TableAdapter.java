package com.volcaniccoder.mobilgarson.adapters;


import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.volcaniccoder.mobilgarson.R;
import com.volcaniccoder.mobilgarson.listeners.OnAdapterClickListener;
import com.volcaniccoder.mobilgarson.models.CommentModel;
import com.volcaniccoder.mobilgarson.models.pojo.TableResult;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl;
import com.volcaniccoder.mobilgarson.table.TablePresenterImpl_MembersInjector;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {


    private List<TableResult> model;
    private long choosenTableId;
    private OnAdapterClickListener listener;
    private Context mContext;

    public TableAdapter(List<TableResult> model, long tableId , OnAdapterClickListener listener,Context context) {
        this.model = model;
        this.choosenTableId = tableId;
        this.listener = listener;
        this.mContext = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_table, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final TableResult result = model.get(position);

        if (result.getStatu() == 1){
            holder.tableIcon.setBackgroundColor(Color.RED);
        }else {
            holder.tableIcon.setBackgroundColor(Color.GREEN);
        }

        if ((long)result.getId() == choosenTableId){
            holder.tableIcon.setBackground(ContextCompat.getDrawable(mContext,R.drawable.ic_action_plus));
        }

        holder.tableName.setText(result.getName());
        holder.tableCapacity.setText("Kapasite: " + result.getCapacity());

        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (choosenTableId == -1){
                    if (result.getStatu() == 1){
                        Toast.makeText(mContext, "Bu masa şu an uygun değil", Toast.LENGTH_SHORT).show();
                    }else {
                        listener.onClickAdapterListener(v,position);
                    }
                }else {
                    Toast.makeText(mContext, "Aynı anda iki masa seçemezsiniz", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return model.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.item_table)
        LinearLayout parent;
        @BindView(R.id.tableIcon)
        ImageView tableIcon;
        @BindView(R.id.tableName)
        TextView tableName;
        @BindView(R.id.tableCapacity)
        TextView tableCapacity;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
