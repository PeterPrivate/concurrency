package com.guanxy.concurrency.example.atomic;

import com.guanxy.concurrency.annoations.ThreadSafe;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/19
 */
@Slf4j
@ThreadSafe
public class AtomicExample4 {

  private static AtomicReference<Integer> count = new AtomicReference<>(0);

  public static void main(String[] args) {
    count.compareAndSet(0, 2);
    count.compareAndSet(0, 1);
    count.compareAndSet(1, 3);
    count.compareAndSet(2, 4);
    count.compareAndSet(3, 5);

    log.info("count:{}", count.get());

  }


}
