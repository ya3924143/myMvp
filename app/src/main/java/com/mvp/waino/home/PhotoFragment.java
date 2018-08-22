package com.mvp.waino.home;

import android.os.Bundle;

import com.mvp.waino.base.BaseFragment;
import com.mvp.waino.mymvp.R;

/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public class PhotoFragment extends BaseFragment {

    public static PhotoFragment newInstance() {

        Bundle args = new Bundle();

        PhotoFragment fragment = new PhotoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_photo;
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
