package com.mvp.waino;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.widget.FrameLayout;

import com.mvp.waino.base.BaseActivity;
import com.mvp.waino.mymvp.R;
import com.mvp.waino.utils.BottomNavigationViewHelper;
import com.mvp.waino.utils.WLog;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {


    @BindView(R.id.fl_home)
    FrameLayout flHome;
    @BindView(R.id.bnv_home)
    BottomNavigationView bnvHome;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        super.initView();
        BottomNavigationViewHelper.disableShiftMode(bnvHome);
    }

}
