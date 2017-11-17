package com.isymobilegames.witterbug.base;

import com.isymobilegames.witterbug.dagger.MockedCoreComponent;

/** Created by justinyang on 11/17/17. */
public class MockedBaseTest extends BaseTest<MockedCoreComponent> {

  @Override
  protected MockedCoreComponent buildComponent() {
    return null;
  }
}
