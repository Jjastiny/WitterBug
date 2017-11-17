package com.isymobilegames.witterbug.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.isymobilegames.witterbug.R;
import com.isymobilegames.witterbug.dagger.ComponentHolder;
import com.isymobilegames.witterbug.rest.BaseService;

import javax.inject.Inject;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;

public class MainActivity extends AppCompatActivity {

  private static final String TAG = MainActivity.class.getSimpleName();

  @Inject BaseService baseService;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ComponentHolder.getCoreComponent().inject(this);

    baseService
        .getStatus()
        .flatMapIterable(responses -> responses)
        .subscribeOn(Schedulers.io())
        .subscribe(
            status -> Log.d(TAG, "onCreate: " + status.getText()),
            throwable -> throwable.printStackTrace());
  }
}
