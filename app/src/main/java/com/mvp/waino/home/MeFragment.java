package com.mvp.waino.home;

import android.os.Bundle;

import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.mymvp.R;

/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class MeFragment extends BaseFragment {

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

    }

    @Override
    protected void initData() {

    }
}
