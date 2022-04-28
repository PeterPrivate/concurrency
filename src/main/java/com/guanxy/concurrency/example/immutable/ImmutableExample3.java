package com.guanxy.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.guanxy.concurrency.annoations.ThreadSafe;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/28
 */
@Slf4j
public class ImmutableExample3 {

  private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

  private final static ImmutableSet set = ImmutableSet.copyOf(list);

  private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

  private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap
      .<Integer, Integer>builder().put(1, 2).put(3, 4).build();

  public static void main(String[] args) {
//    list.add(1);
//    set.add(2);
//    map2.put(1,2);
    System.out.println(map2.get(3));
  }

}
