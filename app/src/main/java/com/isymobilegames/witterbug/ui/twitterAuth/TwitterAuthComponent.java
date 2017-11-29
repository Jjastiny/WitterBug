package com.isymobilegames.witterbug.ui.twitterAuth;

import dagger.Subcomponent;

/** Created by justinyang on 11/15/17. */
@TwitterAuthScope
@Subcomponent()
public interface TwitterAuthComponent {
  TwitterAuthPresenter twitterAuthPresenter();

  @Subcomponent.Builder
  interface Builder {
    TwitterAuthComponent build();
  }
}
