package com.mvp.waino;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.mvp.waino.base.BaseActivity;
import com.mvp.waino.home.HomeFragment;
import com.mvp.waino.home.MeFragment;
import com.mvp.waino.home.PhotoFragment;
import com.mvp.waino.home.VideoFragment;
import com.mvp.waino.mymvp.R;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.ActivityEvent;

import butterknife.BindView;
import io.reactivex.Observable;
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.SupportFragment;


public class MainActivity extends BaseActivity {

    @BindView(R.id.fl_home)
    FrameLayout flHome;
    @BindView(R.id.bnv_home)
    BottomNavigationView bnvHome;

    SupportFragment[] fragments = new SupportFragment[4];
    FragmentManager fragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            return false;
        }
    };

    private static final int HOME = 0;
    private static final int VIDEO = 1;
    private static final int PHOTO = 2;
    private static final int ME = 3;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @SuppressLint("ResourceType")
    @Override
    protected void initView() {
        super.initView();
        ImmersionBar.with(this).statusBarColor(R.color.colorPrimary);
        fragments[HOME] = HomeFragment.newInstance();
        fragments[VIDEO] = VideoFragment.newInstance();
        fragments[PHOTO] = PhotoFragment.newInstance();
        fragments[ME] = MeFragment.newInstance();

        fragmentManager = getSupportFragmentManager();

        loadMultipleRootFragment(R.id.fl_home, HOME, fragments[HOME], fragments[VIDEO], fragments[PHOTO], fragments[ME]);

        bnvHome.setItemTextColor(getResources().getColorStateList(R.drawable.selector_home_color));
        bnvHome.setItemIconTintList(getResources().getColorStateList(R.drawable.selector_home_color));

        bnvHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                showHideFragment(fragments[menuItem.getItemId()], fragments[menuItem.getItemId()]);
                return false;
            }
        });
    }

    @Override
    public Observable<ActivityEvent> lifecycle() {
        return null;
    }

    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(ActivityEvent activityEvent) {
        return null;
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return null;
    }
}
