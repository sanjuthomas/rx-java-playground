package com.sanjuthomas.reduce;


import io.reactivex.Observable;

public class ReduceExample {

  public static void main(String[] args) {

      Observable.range(1, 10)
      .filter(r -> r % 2 == 0)
      .reduce((x, y) -> x  + y)
      .subscribe(r -> System.out.println(r));

  }

}
