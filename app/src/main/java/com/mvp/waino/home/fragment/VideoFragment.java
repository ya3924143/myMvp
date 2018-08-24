package com.mvp.waino.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gyf.barlibrary.ImmersionBar;
import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.mymvp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class VideoFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

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
        ImmersionBar.with(_mActivity).titleBar(toolbar);
    }

    @Override
    protected void initData() {

    }

}
