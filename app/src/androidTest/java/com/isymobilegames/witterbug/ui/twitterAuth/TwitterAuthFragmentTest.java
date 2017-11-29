package com.isymobilegames.witterbug.ui.twitterAuth;

import android.support.annotation.NonNull;

import com.isymobilegames.witterbug.base.BaseFragmentTest;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.verify;

/** Created by justinyang on 11/28/17. */
public class TwitterAuthFragmentTest
    extends BaseFragmentTest<TwitterAuthFragment, TwitterAuthPresenter> {

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();
    getBaseComponent().inject(this);
  }

  @Test
  public void name() throws Exception {
    startFragment();
    verify(getMockPresenter()).retrieveRequestToken();
  }

  @NonNull
  @Override
  protected Class<TwitterAuthFragment> getFragmentClass() {
    return TwitterAuthFragment.class;
  }

  @NonNull
  @Override
  protected Class<TwitterAuthPresenter> getPresenterClass() {
    return TwitterAuthPresenter.class;
  }
}
