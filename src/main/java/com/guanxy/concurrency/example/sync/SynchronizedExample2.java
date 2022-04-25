package com.guanxy.concurrency.example.sync;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@Slf4j
public class SynchronizedExample2 {

  // 修饰一个类
  public static void test1(int j) {
    synchronized (SynchronizedExample2.class) {
      for (int i = 0; i < 10; i++) {
        log.info("test1 {} - {}", j, i);
      }
    }
  }

  // 修饰一个静态方法
  public static synchronized void test2(int j) {
    for (int i = 0; i < 10; i++) {
      log.info("test2 {} - {}", j, i);
    }
  }

  public static void main(String[] args) {
    SynchronizedExample2 example1 = new SynchronizedExample2();
    SynchronizedExample2 example2 = new SynchronizedExample2();
    ExecutorService executorService = Executors.newCachedThreadPool();
    executorService.execute(() -> {
      example1.test1(1);
    });
    executorService.execute(() -> {
      example2.test1(2);
    });
  }

}
