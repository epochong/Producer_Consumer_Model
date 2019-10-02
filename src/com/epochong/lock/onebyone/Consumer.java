package com.epochong.lock.onebyone;

/**
 * @author epochong
 * @date 2019/10/1 23:02
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Consumer extends Thread {

    Service service;

    public Consumer(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            service.get();
        }
    }
}
