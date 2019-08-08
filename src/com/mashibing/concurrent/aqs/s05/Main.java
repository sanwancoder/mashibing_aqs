package com.mashibing.concurrent.aqs.s05;

import java.util.concurrent.locks.Lock;

/**
 * @Author: wuqing
 */
public class Main {

  static int m = 0;

  public static Lock lock = new MLock();

  //锁得住
  public static void main(String[] args) throws Exception {
    Thread[] threads = new Thread[100];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(() -> {
        try {
          lock.lock();
          for (int j = 0; j < 100; j++) {
            m++;
          }
        } finally {
          lock.unlock();
        }
      });
    }

    for (Thread t : threads) {
      t.start();
    }
    for (Thread t : threads) {
      t.join();   //等待所有线程运行结束
    }

    System.out.println(m);    //代码输出随机
  }

}
