package com.nvk.reasysctaskver1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BaiThoAdapter extends RecyclerView.Adapter<BaiThoAdapter.BaiThoHolder> {

    private LayoutInflater inflater;
    private List<BaiTho> baiThoList;

    public BaiThoAdapter(Context context, List<BaiTho> baiThoList) {
        this.inflater = LayoutInflater.from(context);
        this.baiThoList = baiThoList;
    }

    @NonNull
    @Override
    public BaiThoAdapter.BaiThoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.custom_item_baitho,parent,false);
        return new BaiThoHolder(view,this);
    }

    @Override
    public void onBindViewHolder(@NonNull BaiThoAdapter.BaiThoHolder holder, int position) {
        BaiTho baiTho = baiThoList.get(position);
        holder.tvTacGia.setText(baiTho.getTacGia());
        holder.tvTitle.setText(baiTho.getTitle());
    }

    @Override
    public int getItemCount() {
        return baiThoList.size();
    }

    public class BaiThoHolder extends RecyclerView.ViewHolder {
        public final BaiThoAdapter baiThoAdapter;
        private TextView tvTacGia,tvTitle;

        public BaiThoHolder(@NonNull View itemView, BaiThoAdapter baiThoAdapter) {
            super(itemView);
            this.baiThoAdapter = baiThoAdapter;

            tvTacGia = itemView.findViewById(R.id.tvTacGia1);
            tvTitle = itemView.findViewById(R.id.tvTieuDe1);

        }
    }
}
