package com.sanjuthomas.test;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class FlatMapTest1 {

  public static void main(String[] args) {

    long currentTimeMillis = System.currentTimeMillis();

    Observable.range(1, 10)
      .flatMap(val -> Observable.just(val).observeOn(Schedulers.computation()))
      .flatMap(r -> {
        System.out.println("Thread id "+ Thread.currentThread().getId());
        Thread.sleep(1000);
        return Observable.just(r * r);
      })
      .blockingSubscribe(result -> System.out.println(result));

    System.out.println("Time taken: " + String.valueOf(System.currentTimeMillis() - currentTimeMillis));
  }


}
