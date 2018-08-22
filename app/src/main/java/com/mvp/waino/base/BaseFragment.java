package com.mvp.waino.base;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.android.FragmentEvent;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import me.yokeyword.fragmentation.Fragmentation;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * @author waino
 * @date 2018/8/22
 * @desc todo
 */
public abstract class BaseFragment extends SupportFragment implements LifecycleProvider<FragmentEvent> {

    protected String TAG = this.getClass().getSimpleName();

    protected BehaviorSubject<FragmentEvent> lifecycle = BehaviorSubject.create();

    protected View rootView;
    Unbinder unbinder;

    protected abstract int getLayout();

    protected abstract void initPresenter();

    protected abstract void initView();

    protected abstract void initData();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lifecycle.onNext(FragmentEvent.CREATE_VIEW);
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
        }
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onLazyInitView(@Nullable Bundle savedInstanceState) {
        super.onLazyInitView(savedInstanceState);
        initView();
        initPresenter();
        initData();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        lifecycle.onNext(FragmentEvent.ATTACH);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lifecycle.onNext(FragmentEvent.CREATE);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onStart() {
        super.onStart();
        lifecycle.onNext(FragmentEvent.START);
    }

    @Override
    public void onResume() {
        super.onResume();
        lifecycle.onNext(FragmentEvent.RESUME);
    }

    @Override
    public void onPause() {
        super.onPause();
        lifecycle.onNext(FragmentEvent.PAUSE);
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycle.onNext(FragmentEvent.STOP);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        lifecycle.onNext(FragmentEvent.DESTROY_VIEW);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.onNext(FragmentEvent.DESTROY);

        unbinder.unbind();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        lifecycle.onNext(FragmentEvent.DETACH);
    }

    @Override
    public Observable<FragmentEvent> lifecycle() {
        return null;
    }

    @Override
    public <T> LifecycleTransformer<T> bindUntilEvent(FragmentEvent fragmentEvent) {
        return null;
    }

    @Override
    public <T> LifecycleTransformer<T> bindToLifecycle() {
        return null;
    }

    protected void go2Act(Class<? extends Activity> desiAct) {
        go2Act(desiAct, null);
    }

    protected void go2Act(Class<? extends Activity> desiAct, Bundle bundle) {
        Intent intent = new Intent(getActivity(), desiAct);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    protected void go2Act4Result(Class<? extends Activity> desiAct, int requestCode) {
        go2Act4Result(desiAct, requestCode, null);
    }

    protected void go2Act4Result(Class<? extends Activity> desiAct, int requestCode, Bundle bundle) {
        Intent intent = new Intent(getActivity(), desiAct);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

}
