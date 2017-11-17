package com.isymobilegames.witterbug.dagger;

import com.isymobilegames.witterbug.ui.MainActivity;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthActivity;

/** Created by justinyang on 10/9/17. */
public interface CoreComponentBase {
  void inject(MainActivity mainActivity);
}
