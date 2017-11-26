package com.isymobilegames.witterbug.dagger;

import com.isymobilegames.witterbug.dagger.module.MockedAndroidModule;
import com.isymobilegames.witterbug.dagger.module.MockedRestModule;
import com.isymobilegames.witterbug.dagger.modules.MockedRetrofitModule;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthActivityTest;

import javax.inject.Singleton;

import dagger.Component;

/** Created by justinyang on 11/17/17. */
@Singleton
@Component(
  modules = {MockedAndroidModule.class, MockedRetrofitModule.class, MockedRestModule.class}
)
public interface MockedCoreComponent extends CoreComponent {
  void inject(TwitterAuthActivityTest twitterAuthActivityTest);
}
