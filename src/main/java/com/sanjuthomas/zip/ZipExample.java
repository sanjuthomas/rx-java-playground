package com.sanjuthomas.zip;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;

public class ZipExample {

  public static void main(String[] args) {

    Observable<Map<Object, Object>> a = Observable.just(new HashMap<>())
      .subscribeOn(Schedulers.computation())
      .map(val -> calc(val));
    Observable<Map<Object, Object>> b = Observable.just(new HashMap<>())
      .subscribeOn(Schedulers.computation())
      .map(val -> calc(val));
    Observable<Map<Object, Object>> c = Observable.just(new HashMap<>())
      .subscribeOn(Schedulers.computation())
      .map(val -> calc(val));
    Observable.zip(a, b, c, (x, y, z) -> putTogether(x, y, z)).subscribe( r -> System.out.println(r));

  }

  private static Map<Object, Object> putTogether(Map<Object, Object> a, Map<Object, Object> b, Map<Object, Object> c) {
    a.putAll(b);
    a.putAll(c);
    return a;
  }

  private static Map<Object, Object> calc(HashMap<Object, Object> val) {
    System.out.println(System.currentTimeMillis());
    val.put(String.valueOf(System.currentTimeMillis()), String.valueOf(System.currentTimeMillis()));
    return val;
  }

}
