package com.mvp.waino.home.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.gyf.barlibrary.ImmersionBar;
import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.mymvp.R;
import com.mvp.waino.utils.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;


/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class HomeFragment extends BaseFragment {

    static final int REFRESH_COMPLETE = 0X1112;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.banner)
    Banner banner;

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
        String[] urls = {"http://y.photo.qq.com/img?s=7EsxweO3r&l=y.jpg",
                "http://y.photo.qq.com/img?s=DwHzlgSz9&l=y.jpg",
                "http://y.photo.qq.com/img?s=6CtoFstm0&l=y.jpg",
                "http://y.photo.qq.com/img?s=QhjopdDTs&l=y.jpg",
                "http://y.photo.qq.com/img?s=AjRuNnnSn&l=y.jpg"};

        String[] titles = {"小兔子~",
                "测试一下",
                "测试标题",
                "第四个banner",
                "第五个banner"};

        List<String> url = Arrays.asList(urls);
        List<String> title = Arrays.asList(titles);
        List<String> list = new ArrayList<>(url);
        List<String> list1 = new ArrayList<String>(title);
        banner.update(list, list1);
//        http://y.photo.qq.com/img?s=7EsxweO3r&l=y.jpg
//        http://y.photo.qq.com/img?s=DwHzlgSz9&l=y.jpg
//        http://y.photo.qq.com/img?s=6CtoFstm0&l=y.jpg
//        http://y.photo.qq.com/img?s=QhjopdDTs&l=y.jpg
//        http://y.photo.qq.com/img?s=AjRuNnnSn&l=y.jpg

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        banner.setImageLoader(new GlideImageLoader());
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.isAutoPlay(true);
        banner.setDelayTime(2000);
        banner.setIndicatorGravity(BannerConfig.RIGHT);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                Toast.makeText(getContext(),"你点击了："+i, Toast.LENGTH_SHORT).show();
            }
        });
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
