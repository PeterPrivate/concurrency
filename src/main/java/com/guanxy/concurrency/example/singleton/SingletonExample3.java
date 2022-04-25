package com.guanxy.concurrency.example.singleton;

import com.guanxy.concurrency.annoations.NotRecommend;
import com.guanxy.concurrency.annoations.ThreadSafe;

/**
 * description
 * 懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

  // 私有构造函数
  private SingletonExample3() {

  }

  // 单例对象
  private static SingletonExample3 instance = null;

  // 静态的工厂方法
  public static synchronized SingletonExample3 getInstance() {
    if (instance == null) {
      instance = new SingletonExample3();
    }
    return instance;
  }

}
