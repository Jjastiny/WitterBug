package com.isymobilegames.witterbug.rest;

import com.isymobilegames.witterbug.data.status.Response;
import com.isymobilegames.witterbug.data.status.Status;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;

/** Created by justinyang on 11/15/17. */
public interface BaseService {
  @GET("statuses/home_timeline.json")
  Flowable<List<Response>> getStatus();
}
