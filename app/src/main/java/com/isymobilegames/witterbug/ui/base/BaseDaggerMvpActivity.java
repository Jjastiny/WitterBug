package com.isymobilegames.witterbug.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegate;
import com.hannesdorfmann.mosby3.mvp.delegate.ActivityMvpDelegateImpl;
import com.hannesdorfmann.mosby3.mvp.delegate.MvpDelegateCallback;

/** Created by justinyang on 11/16/17. */
public abstract class BaseDaggerMvpActivity<V extends MvpView, P extends MvpBasePresenter<V>>
    extends AppCompatActivity implements MvpView, MvpDelegateCallback<V, P> {
  protected ActivityMvpDelegate<V, P> mvpDelegate;
  protected P presenter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    injectComponent();
    getMvpDelegate().onCreate(savedInstanceState);
  }

  public abstract void injectComponent();

  @Override
  protected void onDestroy() {
    super.onDestroy();
    getMvpDelegate().onDestroy();
  }

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    getMvpDelegate().onSaveInstanceState(outState);
  }

  @Override
  protected void onPause() {
    super.onPause();
    getMvpDelegate().onPause();
  }

  @Override
  protected void onResume() {
    super.onResume();
    getMvpDelegate().onResume();
  }

  @Override
  protected void onStart() {
    super.onStart();
    getMvpDelegate().onStart();
  }

  @Override
  protected void onStop() {
    super.onStop();
    getMvpDelegate().onStop();
  }

  @Override
  protected void onRestart() {
    super.onRestart();
    getMvpDelegate().onRestart();
  }

  @Override
  public void onContentChanged() {
    super.onContentChanged();
    getMvpDelegate().onContentChanged();
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    getMvpDelegate().onPostCreate(savedInstanceState);
  }

  /**
   * Instantiate a presenter instance
   *
   * @return The {@link MvpPresenter} for this view
   */
  @NonNull
  @Override
  public abstract P createPresenter();

  /**
   * Get the mvp delegate. This is internally used for creating presenter, attaching and detaching
   * view from presenter.
   *
   * <p><b>Please note that only one instance of mvp delegate should be used per Activity
   * instance</b>.
   *
   * <p>Only override this method if you really know what you are doing.
   *
   * @return {@link ActivityMvpDelegateImpl}
   */
  @NonNull
  protected ActivityMvpDelegate<V, P> getMvpDelegate() {
    if (mvpDelegate == null) {
      mvpDelegate = new ActivityMvpDelegateImpl(this, this, true);
    }

    return mvpDelegate;
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
