package com.isymobilegames.witterbug.base;

import android.support.test.runner.AndroidJUnit4;

import com.isymobilegames.witterbug.dagger.modules.MockedCoreComponent;

import org.junit.runner.RunWith;

/** Created by justinyang on 11/17/17. */
@RunWith(AndroidJUnit4.class)
public class MockedBaseTest extends BaseTest<MockedCoreComponent> {

  @Override
  protected MockedCoreComponent buildComponent() {
    return null;
  }
}
