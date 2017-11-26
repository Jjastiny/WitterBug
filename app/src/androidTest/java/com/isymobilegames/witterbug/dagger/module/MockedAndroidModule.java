package com.isymobilegames.witterbug.dagger.module;

import android.content.Context;

import com.isymobilegames.witterbug.util.Preferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/** Created by justinyang on 11/22/17. */
@Module
public class MockedAndroidModule {

  @Provides
  Context applicationContext() {
    return mock(Context.class);
  }

  @Provides
  @Singleton
  Preferences providesPreferences() {
    return mock(Preferences.class);
  }
}
