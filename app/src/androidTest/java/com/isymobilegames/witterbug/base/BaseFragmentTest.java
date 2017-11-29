package com.isymobilegames.witterbug.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.isymobilegames.witterbug.ui.base.BaseMvpFragment;
import com.isymobilegames.witterbug.ui.base.TestActivity;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/** Created by justinyang on 11/28/17. */
public abstract class BaseFragmentTest<F extends BaseMvpFragment, P extends MvpBasePresenter>
    extends BaseActivityTest<TestActivity> {

  private P mockPresenter;

  private F fragment;

  @NonNull
  @Override
  public Class<TestActivity> getActivityClass() {
    return TestActivity.class;
  }

  @NonNull
  protected abstract Class<F> getFragmentClass();

  @NonNull
  protected abstract Class<P> getPresenterClass();

  protected F getFragment() {
    return fragment;
  }

  protected P getMockPresenter() {
    return mockPresenter;
  }

  protected final void startFragment() {
    startFragment(getFragmentClass(), getPresenterClass());
  }

  private void startFragment(Class<F> fragmentType, Class<P> presenterType) {
    try {
      fragment = fragmentType.newInstance();

      mockPresenter = mock(presenterType);
      fragment.setPresenter(mockPresenter);

      getActivity()
          .getSupportFragmentManager()
          .beginTransaction()
          .replace(android.R.id.content, fragment)
          .commit();

      waitForIdleSync();
//      fragment.setPresenter(mockPresenter);

    } catch (InstantiationException e) {
      fail(e.getMessage());
    } catch (IllegalAccessException e) {
      fail(e.getMessage());
    }
  }
}
