package com.isymobilegames.witterbug.dagger.components;

import com.isymobilegames.witterbug.dagger.module.MosbyModule;
import com.isymobilegames.witterbug.dagger.scope.MosbyScope;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthFragment;

import dagger.Component;
import dagger.Subcomponent;

/** Created by justinyang on 11/28/17. */
@MosbyScope
@Subcomponent(modules = MosbyModule.class)
public interface MosbyComponent {

  void inject(TwitterAuthFragment twitterAuthFragment);

}
