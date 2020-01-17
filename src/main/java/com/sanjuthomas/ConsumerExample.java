package com.sanjuthomas;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class ConsumerExample {

  public static void main(String[] args) {

    Flowable.range(1, 10000)
      .flatMap(i -> Flowable.just(i).observeOn(Schedulers.computation()))
      .subscribe(new MyConsumer());

    while (true) {}

  }

}
