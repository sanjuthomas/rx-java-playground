package com.sanjuthomas;

import io.reactivex.Observable;

import io.reactivex.functions.Function;

public class MyFunction implements Function<Integer, Observable<Integer>> {

  @Override
  public Observable<Integer> apply(Integer integer) throws Exception {
    System.out.println("Thread Id "+ Thread.currentThread().getId());
    return Observable.just(integer * 10);
  }
}
