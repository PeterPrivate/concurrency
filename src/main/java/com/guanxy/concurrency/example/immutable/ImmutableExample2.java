package com.guanxy.concurrency.example.immutable;

import com.google.common.collect.Maps;
import com.guanxy.concurrency.annoations.NotThreadSafe;
import com.guanxy.concurrency.annoations.ThreadSafe;
import java.util.Collections;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/28
 */
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

  private static Map<Integer, Integer> map = Maps.newHashMap();

  static {
    map.put(1, 2);
    map.put(3, 4);
    map.put(5, 6);
    map = Collections.unmodifiableMap(map);
  }

  public static void main(String[] args) {
    log.info("{}", map.get(1));
    map.put(1, 3);
    log.info("{}", map.get(1));

  }

}
