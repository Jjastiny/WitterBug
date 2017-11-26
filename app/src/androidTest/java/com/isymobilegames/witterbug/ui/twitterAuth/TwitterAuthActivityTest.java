package com.isymobilegames.witterbug.ui.twitterAuth;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.matcher.ViewMatchers;

import com.isymobilegames.witterbug.base.BaseActivityTest;
import com.isymobilegames.witterbug.base.BaseTest;
import com.isymobilegames.witterbug.base.MockedBaseTest;
import com.isymobilegames.witterbug.dagger.ComponentHolder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import javax.inject.Inject;

import retrofit2.Retrofit;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

/** Created by justinyang on 11/17/17. */
public class TwitterAuthActivityTest extends BaseActivityTest<TwitterAuthActivity> {

  @Inject Retrofit retrofit;
  @Mock TwitterAuthPresenter twitterAuthPresenter;

  @Override
  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    super.setUp();
    getBaseComponent().inject(this);
    getActivity().setPresenter(twitterAuthPresenter);
  }

  @Test
  public void name() throws Exception {
      verify(twitterAuthPresenter).retrieveRequestToken();
//    Espresso.onView(ViewMatchers.withId()).check();
    //    getBaseComponent().inject(this);
  }

  @Override
  public Class<TwitterAuthActivity> getActivityClass() {
    return TwitterAuthActivity.class;
  }
}
