package com.isymobilegames.witterbug.dagger;

import com.isymobilegames.witterbug.dagger.components.CoreComponent;
import com.isymobilegames.witterbug.dagger.modules.MockedAndroidModule;
import com.isymobilegames.witterbug.dagger.modules.MockedPresenterModule;
import com.isymobilegames.witterbug.dagger.modules.MockedRestModule;
import com.isymobilegames.witterbug.dagger.modules.MockedRetrofitModule;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthComponent;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthFragmentTest;

import javax.inject.Singleton;

import dagger.Component;

/** Created by justinyang on 11/17/17. */
@Singleton
@Component(
  modules = {
    MockedAndroidModule.class,
    MockedRetrofitModule.class,
    MockedRestModule.class,
    MockedPresenterModule.class
  }
)
public interface MockedCoreComponent extends CoreComponent {
//  TwitterAuthComponent twitterAuthComponent();

  void inject(TwitterAuthFragmentTest twitterAuthFragmentTest);
}
