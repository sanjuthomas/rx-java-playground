package com.sanjuthomas;

import io.reactivex.functions.Consumer;

public class MyConsumer implements Consumer<Integer> {

  @Override
  public void accept(Integer integer) throws Exception {
    System.out.println("Thread id " + Thread.currentThread().getId());
    System.out.println(integer);
  }
}
