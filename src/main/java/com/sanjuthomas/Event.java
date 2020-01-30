package com.sanjuthomas;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Event {

  private String type;
  private String payload;

  public Event(final String type, String payload) {
    this.type = type;
    this.payload = payload;
  }

  public String toString() {
    return type + ":" + payload;
  }


  public static void main(String[] args) {

    Observable<Event> observable = Observable.fromArray(
      new Event("BIRTH", "John"),
      new Event("BIRTH", "Mike"),
      new Event("BIRTH", "Martin"),
      new Event("DEATH", "Sam"),
      new Event("DEATH", "George")
    );

    observable.groupBy(event -> event.type)
      .flatMap(l -> l.buffer(2, TimeUnit.SECONDS, 10)
        .map(new Transformer()))
      .blockingSubscribe(r -> Observable.fromIterable(r.entrySet()).subscribe(e -> {
          System.out.println(e.getKey());
          System.out.println(e.getValue());
        }
      ));
  }

  public static class Transformer implements Function<List<Event>, Map<String, List<String>>> {

    @Override
    public Map<String, List<String>> apply(List<Event> events) {
      final Map<String, List<String>> result = new HashMap<>();
      Observable.fromIterable(events)
        .subscribe(r -> result.computeIfAbsent(r.type, k -> new ArrayList<>()).add(r.payload));
      return result;
    }
  }
}


