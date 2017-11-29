package com.isymobilegames.witterbug.dagger.modules;

import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/** Created by justinyang on 11/28/17. */
@Module
public class MockedAuthPresenterModule {
  @Provides
  @Singleton
  public TwitterAuthPresenter providesTwitterAuthPresenter() {
    return mock(TwitterAuthPresenter.class);
  }
}
