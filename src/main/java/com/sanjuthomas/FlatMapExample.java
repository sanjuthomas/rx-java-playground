package com.sanjuthomas;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlatMapExample {


  public static void main(String[] args) throws InterruptedException {

    final List<Map<String, String>> items = new ArrayList<Map<String, String>>();
    final Map<String, String> item = new HashMap<>();
    items.add(item);

    Observable.range(1, 10)
      .flatMap(val -> Observable.just(val).observeOn(Schedulers.computation()))
      .flatMap(new MyFunction())
      .flatMap(new MyFunction())
      .blockingSubscribe(result -> System.out.println(result));
  }

}
