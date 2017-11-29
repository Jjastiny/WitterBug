package com.isymobilegames.witterbug.dagger.components;

import com.isymobilegames.witterbug.dagger.module.AndroidModule;
import com.isymobilegames.witterbug.dagger.module.AuthenticatedRetrofitModule;
import com.isymobilegames.witterbug.dagger.module.RestModule;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthFragment;

import javax.inject.Singleton;

import dagger.Component;

/** Created by justinyang on 10/9/17. */
@Singleton
@Component(modules = {AndroidModule.class, RestModule.class, AuthenticatedRetrofitModule.class})
public interface CoreComponent extends CoreComponentBase {

  MosbyComponent mosbyComponent();

}
