package com.premsinghdaksha.trainmaingif.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.premsinghdaksha.trainmaingif.R;
import com.premsinghdaksha.trainmaingif.model.DataDTO;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewholder> {
    private List<DataDTO> dataDTOList;
    private Context mContext;
    private OnClickGif onClickGif;

    public DataAdapter(List<DataDTO> dataDTOList, Context mContext, OnClickGif onClickGif) {
        this.dataDTOList = dataDTOList;
        this.mContext = mContext;
        this.onClickGif = onClickGif;
    }

    @NonNull
    @Override
    public DataViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_layout, parent, false);
        return new DataViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DataViewholder holder, int position) {
        // Glide.with(mContext).load(dataDTOList.get(position).getUrl()).into(holder.gif_);
        String gif = "https://media1.giphy.com/media/" + dataDTOList.get(position).getId() + "/giphy.gif";
        Glide.with(mContext).load(gif).into(holder.gif_);
        holder.title.setText(dataDTOList.get(position).getTitle());
        holder.gif_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickGif.onClik(dataDTOList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataDTOList.size();
    }

    public class DataViewholder extends RecyclerView.ViewHolder {
        private ImageView gif_;
        private TextView title;

        public DataViewholder(@NonNull View itemView) {
            super(itemView);
            gif_ = itemView.findViewById(R.id.gif_);
            title = itemView.findViewById(R.id.title);

        }
    }

    public interface OnClickGif {
        public void onClik(DataDTO dataDTO);
    }
}
