package com.sanjuthomas;

import io.reactivex.Observable;

public class LogExceptionExample {

  public static void main(String[] args) {

    Observable.just(1, 3, 5, 7, 9, 12, 13, 15, 20)
      .map(i -> i * 3)
      .map(j -> {
        if(j %2  == 0) {
          return j / 0;
        }
        return j;
      })
      .blockingSubscribe(
        result -> System.out.println(result),
        error -> {
          error.printStackTrace();
       });
  }
}
