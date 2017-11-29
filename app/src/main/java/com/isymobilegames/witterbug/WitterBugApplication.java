package com.isymobilegames.witterbug;

import android.app.Application;

import com.isymobilegames.witterbug.dagger.ComponentBuilder;
import com.isymobilegames.witterbug.dagger.ComponentHolder;
import com.isymobilegames.witterbug.dagger.components.CoreComponent;
import com.isymobilegames.witterbug.dagger.components.DaggerCoreComponent;
import com.isymobilegames.witterbug.dagger.module.AndroidModule;

/** Created by justinyang on 11/15/17. */
public class WitterBugApplication extends Application implements ComponentBuilder {

  @Override
  public void onCreate() {
    super.onCreate();
    if (ComponentHolder.getCoreComponent() == null) {
      ComponentHolder.setCoreComponent(buildCoreComponent());
    }
  }

  @Override
  public CoreComponent buildCoreComponent() {
    return DaggerCoreComponent.builder()
        .androidModule(new AndroidModule(getApplicationContext()))
        .build();
  }
}
