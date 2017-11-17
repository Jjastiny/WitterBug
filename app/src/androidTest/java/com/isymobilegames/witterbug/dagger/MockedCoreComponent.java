package com.isymobilegames.witterbug.dagger;

import android.support.test.espresso.core.deps.dagger.Component;
import android.support.test.espresso.core.deps.dagger.Module;

import com.isymobilegames.witterbug.dagger.modules.MockedRetrofitModule;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthActivityTest;

import javax.inject.Singleton;

/** Created by justinyang on 11/17/17. */
@Singleton
@Component(modules = MockedRetrofitModule.class)
public interface MockedCoreComponent extends CoreComponent {
  void inject(TwitterAuthActivityTest twitterAuthActivityTest);
}
