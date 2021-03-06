package com.guanxy.concurrency.example.singleton;

import com.guanxy.concurrency.annoations.NotRecommend;
import com.guanxy.concurrency.annoations.NotThreadSafe;
import com.guanxy.concurrency.annoations.ThreadSafe;

/**
 * description
 * 懒汉模式 -> 双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 *
 * @author Peter Guan
 * @date 2022/4/25
 */
@NotThreadSafe
public class SingletonExample4 {

  // 私有构造函数
  private SingletonExample4() {

  }

  // 1 memory = allocate() 分配对象的内存空间
  // 2 ctorInstance() 初始化对象
  // 3 instance = memory 设置instance指向刚分配的内存

  // JVM 和 CPU 优化，发生了指令重排

  // 1 memory = allocate() 分配对象的内存空间
  // 3 instance = memory 设置instance指向刚分配的内存
  // 2 ctorInstance() 初始化对象

  // 单例对象
  private static SingletonExample4 instance = null;

  // 静态的工厂方法
  public static SingletonExample4 getInstance() {
    /**
     * 双重检测机制不一定线程安全，因为会发生指令重排的问题
     */
    if (instance == null) { // 双重检测机制   // B
      synchronized (SingletonExample4.class) { // 同步锁
        if (instance == null) {
          instance = new SingletonExample4(); // A - 3
        }
      }
    }
    return instance;
  }

}

