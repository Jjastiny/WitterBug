package com.isymobilegames.witterbug.dagger.module;

import android.support.annotation.NonNull;
import android.util.Log;

import com.isymobilegames.witterbug.dagger.scope.AuthScope;
import com.isymobilegames.witterbug.rest.HttpLoggingInterceptor;
import com.isymobilegames.witterbug.util.Preferences;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import oauth.signpost.OAuthConsumer;
import oauth.signpost.OAuthProvider;
import oauth.signpost.basic.DefaultOAuthConsumer;
import oauth.signpost.basic.DefaultOAuthProvider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

/** Created by justinyang on 11/15/17. */
@Module
@AuthScope
public class AuthenticatedRetrofitModule {

  private static final String BASE_URL = "https://api.twitter.com/1.1/";
  private static final String CONSUMER_KEY = "WKe7gCZADqCKmhLU7momQbpil";
  private static final String CONSUMER_SECRET =
      "kdDi5U7qtEBHzzMt87yYkYRd7boqVRCHaDJie6BtCOj3Yk7S9a";
  private static final String TAG = AuthenticatedRetrofitModule.class.getSimpleName();

  @Provides
  @Singleton
  OkHttpClient providesOAuthOkHttpClient(OkHttpOAuthConsumer consumer) {
    HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
    return new OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .addInterceptor(new SigningInterceptor(consumer))
        .build();
  }

  @Provides
  @Singleton
  OkHttpOAuthConsumer provideOkHttpOAuthConsumer(Preferences preferences) {
    OkHttpOAuthConsumer consumer = new OkHttpOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
    consumer.setTokenWithSecret(preferences.getToken(), preferences.getTokenSecret());
    return consumer;
  }

  @Provides
  @Singleton
  OAuthConsumer providesOAuthConsumer() {
    return new DefaultOAuthConsumer(CONSUMER_KEY, CONSUMER_SECRET);
  }

  @Provides
  @Singleton
  OAuthProvider providesOAuthProvider() {
    return new DefaultOAuthProvider(
        "https://api.twitter.com/oauth/request_token",
        "https://api.twitter.com/oauth/access_token",
        "https://api.twitter.com/oauth/authorize");
  }

  @Provides
  @Singleton
  Retrofit providesAuthedRetrofit(OkHttpClient okHttpClient) {
    return new Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }
}
