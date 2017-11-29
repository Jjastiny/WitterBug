package com.isymobilegames.witterbug.ui.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.FragmentMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;

import butterknife.ButterKnife;

/** Created by justinyang on 11/28/17. */
public abstract class BaseMvpFragment<V extends MvpView, P extends MvpPresenter<V>> extends Fragment
    implements MvpView, MvpDelegateCallback<V, P> {

  protected FragmentMvpDelegateImpl<V, P> fragmentMvpDelegate;
  protected P presenter;

  public abstract void injectComponent();

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    injectComponent();
  }

  @Override
  public View onCreateView(
      LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = super.onCreateView(inflater, container, savedInstanceState);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    getMvpDelegate().onViewCreated(view, savedInstanceState);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    getMvpDelegate().onDestroyView();
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getMvpDelegate().onCreate(savedInstanceState);
  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    getMvpDelegate().onDestroy();
  }

  @Override
  public void onPause() {
    super.onPause();
    getMvpDelegate().onPause();
  }

  @Override
  public void onResume() {
    super.onResume();
    getMvpDelegate().onResume();
  }

  @Override
  public void onStart() {
    super.onStart();
    getMvpDelegate().onStart();
  }

  @Override
  public void onStop() {
    super.onStop();
    getMvpDelegate().onStop();
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    getMvpDelegate().onActivityCreated(savedInstanceState);
  }

  @Override
  public void onDetach() {
    super.onDetach();
    getMvpDelegate().onDetach();
  }

  @Override
  public void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    getMvpDelegate().onSaveInstanceState(outState);
  }

  @NonNull
  @Override
  public final P createPresenter() {
    return (presenter == null ? newPresenter() : presenter);
  }

  protected abstract P newPresenter();

  @NonNull
  protected FragmentMvpDelegate<V, P> getMvpDelegate() {
    if (fragmentMvpDelegate == null) {
      fragmentMvpDelegate = new FragmentMvpDelegateImpl<>(this, this, true, true);
    }

    return fragmentMvpDelegate;
  }

  @NonNull
  @Override
  public P getPresenter() {
    return presenter;
  }

  @Override
  public void setPresenter(@NonNull P presenter) {
    this.presenter = presenter;
  }

  @NonNull
  @Override
  public V getMvpView() {
    return (V) this;
  }
}
