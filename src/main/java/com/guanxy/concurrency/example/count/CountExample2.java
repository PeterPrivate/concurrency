package com.guanxy.concurrency.example.count;

import com.guanxy.concurrency.annoations.NotThreadSafe;
import com.guanxy.concurrency.annoations.ThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/19
 */
@Slf4j
@ThreadSafe
public class CountExample2 {

  // 请求总数
  public static int clientTotal = 5000;

  // 同时并发执行的线程数
  public static int threadTotal = 200;

  public static AtomicInteger count = new AtomicInteger(0);

  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newCachedThreadPool();
    final Semaphore semaphore = new Semaphore(threadTotal);
    final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
    for (int i = 0; i < clientTotal; i++) {
      executorService.execute(() -> {
        try {
          semaphore.acquire();
          add();
          semaphore.release();
        } catch (Exception e) {
          log.error("exception", e);
        }
        countDownLatch.countDown();
      });
    }
    countDownLatch.await();
    executorService.shutdown();
    log.info("count:{}", count);
  }

  public static void add() {
    count.incrementAndGet();
//    count.getAndIncrement();
  }

}
