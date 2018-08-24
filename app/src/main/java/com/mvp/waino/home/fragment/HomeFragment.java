package com.mvp.waino.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;


import com.gyf.barlibrary.ImmersionBar;
import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.home.entity.BannerEntity;
import com.mvp.waino.mymvp.R;
import com.mvp.waino.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class HomeFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.banner)
    Banner banner;

    ArrayList<BannerEntity> banners = new ArrayList<>();

    public static HomeFragment newInstance() {
        Bundle args = new Bundle();

        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {
        ImmersionBar.with(_mActivity).titleBar(toolbar);
        initBanner();
    }

    private void initBanner() {
        banners.addAll();
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages();
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles();
        banner.isAutoPlay(true);
        banner.setDelayTime(1000);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.start();
    }

    @Override
    public void onStart() {
        super.onStart();
        banner.startAutoPlay();
    }

    @Override
    public void onStop() {
        super.onStop();
        banner.stopAutoPlay();
    }

    @Override
    protected void initData() {

    }
}
