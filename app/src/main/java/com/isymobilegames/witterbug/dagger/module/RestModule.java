package com.isymobilegames.witterbug.dagger.module;

import com.isymobilegames.witterbug.dagger.scope.AuthScope;
import com.isymobilegames.witterbug.rest.BaseService;
import com.isymobilegames.witterbug.util.Preferences;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/** Created by justinyang on 11/15/17. */
@Module
public class RestModule {

  @Provides
  @Singleton
  BaseService providesBaseService(Retrofit retrofit) {
    return retrofit.create(BaseService.class);
  }
}
