package com.guanxy.concurrency;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * description
 *
 * @author Peter Guan
 * @date 2022/4/18
 */
@Controller
@Slf4j
public class TestController {

  @RequestMapping("/test")
  @ResponseBody
  public String test() {
//    log.info("this return test");
    return "test";
  }

}
