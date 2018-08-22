package com.mvp.waino.home;

import android.os.Bundle;

import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.mymvp.R;

/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class VideoFragment extends BaseFragment {

    public static VideoFragment newInstance() {

        Bundle args = new Bundle();

        VideoFragment fragment = new VideoFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayout() {
        return R.layout.fragment_video;
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
