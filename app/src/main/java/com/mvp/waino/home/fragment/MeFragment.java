package com.mvp.waino.home.fragment;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.gyf.barlibrary.ImmersionBar;
import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.mymvp.R;

import butterknife.BindView;

/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class MeFragment extends BaseFragment {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    public static MeFragment newInstance() {

        Bundle args = new Bundle();

        MeFragment fragment = new MeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_me;
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
