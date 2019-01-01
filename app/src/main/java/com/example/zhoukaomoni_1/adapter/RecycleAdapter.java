package com.example.zhoukaomoni_1.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhoukaomoni_1.R;
import com.example.zhoukaomoni_1.bean.ShopBean;
import com.example.zhoukaomoni_1.utils.StringUtils;


import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {

    private Context context;
    private List<ShopBean.DataBean> list;

    public RecycleAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View  itemView=View.inflate(context, R.layout.rv_item_linerlayout,null);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final ShopBean.DataBean dataBean = list.get(i);
        String[] split = dataBean.getImages().split("\\|");
        Glide.with(context).load(StringUtils.Http2http(split[0])).into(viewHolder.imgShop);
        viewHolder.tvTitle.setText(dataBean.getTitle());
        viewHolder.tvPrice.setText("￥:"+dataBean.getPrice());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClick.onItemClick(dataBean.getPid()+"");
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imgShop;
        private final TextView tvTitle;
        private final TextView tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgShop = itemView.findViewById(R.id.img_shop);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvPrice = itemView.findViewById(R.id.tv_price);

        }
    }
    public interface OnItemClick{
        void onItemClick(String pid);
    }

    //定义成员变量
    private OnItemClick mOnItemClick;

    //设置方法暴露给外界
    public void setOnItemClickListener(OnItemClick onItemClick) {
        mOnItemClick = onItemClick;
    }
}
