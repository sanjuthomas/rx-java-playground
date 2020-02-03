package com.sanjuthomas.repeat;

import io.reactivex.Observable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class Application {

  public static void main(String[] args) throws InterruptedException {

    AtomicReference<Long> id = new AtomicReference<>();
    Observable.just("")
      .doOnNext(r -> {
          Thread.sleep(1000);
          final Long time = System.currentTimeMillis();
          System.out.println(time);
          id.set(time);
      })
      .delay(100, TimeUnit.MILLISECONDS)
      .repeat(5)
      .subscribe();
      System.out.println("return value - " + id.get());
      Thread.sleep(5000);
  }
}