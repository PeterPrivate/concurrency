package com.guanxy.concurrency.example.publish;

import com.guanxy.concurrency.annoations.NotRecommend;
import com.guanxy.concurrency.annoations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

  private int thisCanBeEscape = 0;

  public Escape() {
    new InnerClass();
  }

  private class InnerClass {

    public InnerClass() {
      log.info("{}", Escape.this.thisCanBeEscape);
    }
  }

  public static void main(String[] args) {
    new Escape();
  }
}
