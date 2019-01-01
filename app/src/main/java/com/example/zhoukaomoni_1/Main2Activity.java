package com.example.zhoukaomoni_1;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.zhoukaomoni_1.bean.DataShopBean;
import com.example.zhoukaomoni_1.fragment.ShopFragment;
import com.example.zhoukaomoni_1.fragment.TextFragment;
import com.example.zhoukaomoni_1.fragment.XiangqinFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Main2Activity extends AppCompatActivity {
    @BindView(R.id.tb_shang)
    TabLayout  tbShang;
    @BindView(R.id.vp_shang)
    ViewPager vpShang;

    private Unbinder bind;
    private List<String> title;
    private List<Fragment> fragmentList;
    private DataShopBean.DataBean data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        bind = ButterKnife.bind(this, this);





        title = new ArrayList<>();
        title.add("商品");
        title.add("详情");
        title.add("评论");

        fragmentList = new ArrayList<>();
        fragmentList.add(new XiangqinFragment());
        fragmentList.add(new TextFragment());
        fragmentList.add(new ShopFragment());
        vpShang.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return title.get(position);
            }

        });
        tbShang.setupWithViewPager(vpShang);
        tbShang.setTabMode(TabLayout.MODE_FIXED);



    }




}
