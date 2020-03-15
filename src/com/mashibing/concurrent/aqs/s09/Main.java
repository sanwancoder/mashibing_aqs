package com.mashibing.concurrent.aqs.s09;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: wuqing
 */
public class Main {

  public static Lock lock = new ReentrantLock();

  public static int count = 3;

  public static void main(String[] args) {

    lock.lock();
    System.out.println(count--);
    lock.lock();
    System.out.println(count--);
    lock.lock();
    System.out.println(count--);
    lock.unlock();
    lock.unlock();

  }

}
