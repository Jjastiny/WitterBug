package com.isymobilegames.witterbug.dagger.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/** Created by justinyang on 11/17/17. */
@Module
public class MockedRetrofitModule {

  @Provides
  @Singleton
  OkHttpClient providesOAuthOkHttpClient() {
    return mock(OkHttpClient.class);
  }

  @Provides
  @Singleton
  OAuthConsumer providesOAuthConsumer() {
    return mock(OAuthConsumer.class);
  }

  @Provides
  @Singleton
  OAuthProvider providesOAuthProvider() {
    return mock(OAuthProvider.class);
  }

}
