package com.isymobilegames.witterbug.dagger.module;

import com.isymobilegames.witterbug.dagger.scope.MosbyScope;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthComponent;

import dagger.Module;
import dagger.Provides;

/** Created by justinyang on 11/28/17. */
@Module(subcomponents = {TwitterAuthComponent.class})
public class MosbyModule {

  @MosbyScope
  @Provides
  TwitterAuthComponent providesTwitterAuthComponent(TwitterAuthComponent.Builder builder) {
    return builder.build();
  }
}
