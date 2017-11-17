package com.isymobilegames.witterbug.dagger.modules;

import android.content.Context;
import android.support.test.espresso.core.deps.dagger.Module;

/** Created by justinyang on 11/17/17. */
@Module
public class MockedAndroidModule {
  private Context context;

  public MockedAndroidModule(Context context) {
    this.context = context;
  }
}
