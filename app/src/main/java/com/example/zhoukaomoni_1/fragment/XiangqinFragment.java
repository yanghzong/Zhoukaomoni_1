package com.example.zhoukaomoni_1.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zhoukaomoni_1.R;
import com.example.zhoukaomoni_1.bean.DataShopBean;
import com.example.zhoukaomoni_1.inter.Cantant;
import com.example.zhoukaomoni_1.presenter.DataShopPresenter;
import com.example.zhoukaomoni_1.utils.StringUtils;
import com.example.zhoukaomoni_1.view.DataView;


import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class XiangqinFragment extends Fragment implements DataView {
    @BindView(R.id.img_xiangqing)
    ImageView  imgXinagqing;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView  tvPrice;
    @BindView(R.id.add_shop)
    Button btnAdd;
    private Unbinder bind;
    private DataShopPresenter presenter;
    private String pid;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.xiangqinfragment_item,container,false);
        EventBus.getDefault().register(getActivity());
       SharedPreferences sp = getActivity().getSharedPreferences("pid", Context.MODE_PRIVATE);
        String pid = sp.getString("pid", "");
        EventBus.getDefault().post(pid);
        presenter = new DataShopPresenter();
        presenter.attach(this);
        presenter.DataShop(Cantant.xiangqing+pid);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bind = ButterKnife.bind(this, getActivity());



    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
    @Override
    public void getData(DataShopBean dataShopBean) {
        DataShopBean.DataBean data = dataShopBean.getData();
        if (data !=null){
            tvTitle.setText(data.getTitle());
            tvPrice.setText(""+ data.getPrice());
            String[] split = data.getImages().split("\\|");
            Glide.with(getActivity()).load(StringUtils.Http2http(split[0])).into(imgXinagqing);


        }
    }

}
