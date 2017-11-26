package com.isymobilegames.witterbug.base;

import android.app.Activity;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import org.junit.Rule;

/** Created by justinyang on 11/22/17. */
public abstract class BaseActivityTest<T extends Activity> extends MockedBaseTest {
  @Rule
  public IntentsTestRule<T> activityIntentsTestRule = new IntentsTestRule<>(getActivityClass());

  private Intent intent;

  public T getActivity() {
    if (activityIntentsTestRule == null) {
      startActivity();
    }
    return activityIntentsTestRule.getActivity();
  }

  private void startActivity() {
    Intent intent = this.intent;
    if (intent == null) {
      intent = new Intent();
    }
    startActivity(intent);
  }

  private void startActivity(Intent intent) {
    activityIntentsTestRule.launchActivity(intent);
  }

  public abstract Class<T> getActivityClass();
}
