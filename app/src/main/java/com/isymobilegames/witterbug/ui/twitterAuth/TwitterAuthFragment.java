package com.isymobilegames.witterbug.ui.twitterAuth;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.isymobilegames.witterbug.R;
import com.isymobilegames.witterbug.dagger.ComponentBuilder;
import com.isymobilegames.witterbug.dagger.ComponentHolder;
import com.isymobilegames.witterbug.ui.MainActivity;
import com.isymobilegames.witterbug.ui.base.BaseMvpFragment;
import com.isymobilegames.witterbug.util.Preferences;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/** Created by justinyang on 11/28/17. */
public class TwitterAuthFragment extends BaseMvpFragment<TwitterAuthView, TwitterAuthPresenter>
    implements TwitterAuthView {

  @BindView(R.id.webview)
  WebView webView;

  //  @Inject TwitterAuthPresenter twitterAuthPresenter;
  @Inject Preferences preferences;
  @Inject TwitterAuthComponent twitterAuthComponent;

  @Override
  protected TwitterAuthPresenter newPresenter() {
    return twitterAuthComponent.twitterAuthPresenter();
  }

  public static TwitterAuthFragment newInstance() {
    return new TwitterAuthFragment();
  }

  @Override
  public void injectComponent() {
    ComponentHolder.getCoreComponent().mosbyComponent().inject(this);
  }

  @Nullable
  @Override
  public View onCreateView(
      @NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_twitter_auth, container, false);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    ButterKnife.bind(this, view);

    getPresenter().retrieveRequestToken();

    webView.setWebViewClient(
        new WebViewClient() {
          @Override
          public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if (url.startsWith("oauth")) {
              Uri uri = Uri.parse(url);
              if (uri.getQueryParameter("oauth_verifier") != null) {
                getPresenter().onOAuthCallback(uri);
              }
              return true;
            }
            return super.shouldOverrideUrlLoading(view, url);
          }
        });
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    getPresenter().detachView(false);
  }

  @Override
  public void loadUrl(String authUrl) {
    webView.loadUrl(authUrl);
  }

  @Override
  public void startNextActivity() {
    if (!getActivity().isFinishing()) {
      //      finish();
      Intent intent = new Intent(getActivity(), MainActivity.class);
      startActivity(intent);
    }
  }
}
