package com.guanxy.concurrency.example.singleton;

import com.guanxy.concurrency.annoations.ThreadSafe;
import java.util.HashMap;

/**
 * description
 * 饿汉模式
 * 单例实例在类装载使用时进行创建
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@ThreadSafe
public class SingletonExample6 {

  // 私有构造函数
  private SingletonExample6() {

  }
  // 单例对象
  private static SingletonExample6 instance = null;

  // 静态代码块是按顺序执行的
  static {
    instance = new SingletonExample6();
  }

  // 静态的工厂方法
  public static SingletonExample6 getInstance() {
    return instance;
  }

  public static void main(String[] args) {
    System.out.println(getInstance().hashCode());
    System.out.println(getInstance().hashCode());
  }
}
