package com.guanxy.concurrency.example.singleton;

import com.guanxy.concurrency.annoations.NotThreadSafe;
import com.guanxy.concurrency.annoations.ThreadSafe;

/**
 * description
 * 饿汉模式
 * 单例实例在类装载使用时进行创建
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@ThreadSafe
public class SingletonExample2 {

  // 私有构造函数
  private SingletonExample2() {

  }

  // 单例对象
  private static SingletonExample2 instance = new SingletonExample2();

  // 静态的工厂方法
  public static SingletonExample2 getInstance() {
    return instance;
  }

}
