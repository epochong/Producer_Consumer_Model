package com.epochong.lock.onebyone;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author epochong
 * @date 2019/10/1 22:52
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Service {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            if (hasValue) {
                //System.out.println("生产者：还有东西呢，等待消费者消费");
                condition.await();
            }
            System.out.println("生产者：我生产了东西了，可以消费了");
            hasValue = true;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            if (!hasValue) {
                //System.out.println("消费者：还没有东西可以消费，我先等一下");
                condition.await();
            }
            System.out.println("消费者：我消费了东西，东西没了，生产者你可以生产了");
            hasValue = false;
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
