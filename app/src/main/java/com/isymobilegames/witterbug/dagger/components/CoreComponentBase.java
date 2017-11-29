package com.isymobilegames.witterbug.dagger.components;

import com.isymobilegames.witterbug.ui.MainActivity;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthActivity;
import com.isymobilegames.witterbug.ui.twitterAuth.TwitterAuthFragment;

/** Created by justinyang on 10/9/17. */
public interface CoreComponentBase {
  void inject(MainActivity mainActivity);

//  void inject(TwitterAuthFragment twitterAuthFragment);
}
