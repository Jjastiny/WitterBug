package com.isymobilegames.witterbug.dagger.module;

import com.isymobilegames.witterbug.rest.BaseService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/** Created by justinyang on 11/15/17. */
@Module
public class RestModule {

  @Provides
  @Singleton
  BaseService providesBaseService(Retrofit retrofit) {
    return retrofit.create(BaseService.class);
  }
}
