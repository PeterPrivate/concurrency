package com.guanxy.concurrency.example.publish;

import com.guanxy.concurrency.annoations.NotThreadSafe;
import com.sun.media.jfxmedia.logging.Logger;
import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@Slf4j
@NotThreadSafe
public class UnsafePublish {

  private String[] states = {"a", "b", "c"};

  public String[] getStates() {
    return states;
  }

  public static void main(String[] args) {
    UnsafePublish unsafePublish = new UnsafePublish();
    log.info("{}", Arrays.toString(unsafePublish.getStates()));

    unsafePublish.getStates()[0] = "d";
    log.info("{}", Arrays.toString(unsafePublish.getStates()));
  }
}
