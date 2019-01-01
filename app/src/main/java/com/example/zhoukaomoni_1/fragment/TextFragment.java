package com.example.zhoukaomoni_1.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.zhoukaomoni_1.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class TextFragment extends Fragment {
    @BindView(R.id.tv_title)
    TextView  tvTitle;

    private Unbinder bind;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.textfragment_item,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bind = ButterKnife.bind(this, getActivity());



    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void yz(){
        tvTitle.setText(EventBus.getDefault().toString());
    }



    @Override
    public void onDestroy() {
        super.onDestroy();
        bind.unbind();
    }
}
