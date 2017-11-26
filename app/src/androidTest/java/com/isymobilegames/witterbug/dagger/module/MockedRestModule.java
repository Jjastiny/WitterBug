package com.isymobilegames.witterbug.dagger.module;

import com.isymobilegames.witterbug.rest.BaseService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static org.mockito.Mockito.mock;

/** Created by justinyang on 11/22/17. */
@Module
public class MockedRestModule {

  @Provides
  @Singleton
  BaseService providesBaseService() {
    return mock(BaseService.class);
  }
}
