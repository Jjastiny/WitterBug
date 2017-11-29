package com.isymobilegames.witterbug.base;

import com.isymobilegames.witterbug.dagger.ComponentHolder;
import com.isymobilegames.witterbug.dagger.components.CoreComponent;

import org.junit.After;
import org.junit.Before;

/** Created by justinyang on 11/17/17. */
public abstract class BaseTest<C extends CoreComponent> {
  private C baseComponent;

  protected abstract C buildComponent();

  @Before
  public void setUp() throws Exception {
    baseComponent = buildComponent();
    ComponentHolder.setCoreComponent(baseComponent);
  }

  @After
  public void tearDown() throws Exception {
    baseComponent = null;
  }

  protected C getBaseComponent() {
    return baseComponent;
  }
}
