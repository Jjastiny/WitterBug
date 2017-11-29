package com.isymobilegames.witterbug.base;

import android.app.Activity;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.v7.app.AppCompatActivity;

import com.isymobilegames.witterbug.dagger.MockedCoreComponent;

import org.junit.Rule;

/** Created by justinyang on 11/22/17. */
public abstract class BaseActivityTest<T extends AppCompatActivity> extends MockedBaseTest {
  @Rule
  public IntentsTestRule<T> activityIntentsTestRule = new IntentsTestRule<>(getActivityClass());

  private Intent intent;

  @Override
  protected MockedCoreComponent buildComponent() {
    return super.buildComponent();
  }

  public T getActivity() {
    if (activityIntentsTestRule == null) {
      startActivity();
    }
    return activityIntentsTestRule.getActivity();
  }

  public void startActivity() {
    Intent intent = this.intent;
    if (this.intent == null) {
      this.intent = new Intent();
    }
    startActivity(intent);
  }

  public void waitForIdleSync() {
    InstrumentationRegistry.getInstrumentation().waitForIdleSync();
  }

  private void startActivity(Intent intent) {
    activityIntentsTestRule.launchActivity(intent);
  }

  public abstract Class<T> getActivityClass();
}
