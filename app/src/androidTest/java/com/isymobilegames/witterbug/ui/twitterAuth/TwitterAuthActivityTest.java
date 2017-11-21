package com.isymobilegames.witterbug.ui.twitterAuth;

import com.isymobilegames.witterbug.base.BaseTest;
import com.isymobilegames.witterbug.base.MockedBaseTest;
import com.isymobilegames.witterbug.dagger.ComponentHolder;

import org.junit.Test;

import javax.inject.Inject;

import retrofit2.Retrofit;

import static org.junit.Assert.*;

/** Created by justinyang on 11/17/17. */
public class TwitterAuthActivityTest extends MockedBaseTest {
  @Inject Retrofit retrofit;

  @Test
  public void name() throws Exception {
    getBaseComponent().inject(this);
  }
}
