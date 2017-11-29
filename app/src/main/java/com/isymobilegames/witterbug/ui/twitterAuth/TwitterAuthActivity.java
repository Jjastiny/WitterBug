package com.isymobilegames.witterbug.ui.twitterAuth;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.isymobilegames.witterbug.R;
import com.isymobilegames.witterbug.dagger.ComponentHolder;

import butterknife.ButterKnife;

/** Created by justinyang on 11/15/17. */
public class TwitterAuthActivity extends AppCompatActivity {
  private static final String TAG = TwitterAuthActivity.class.getSimpleName();

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_twitter_auth);
    ButterKnife.bind(this);
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(R.id.activity_twitter_auth, TwitterAuthFragment.newInstance());
    fragmentTransaction.commit();
  }
}
