package com.epochong.lock.onebyone;

/**
 * @author epochong
 * @date 2019/10/1 22:59
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Producer extends Thread{

    private Service service;

    public Producer(Service service) {
        this.service = service;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            service.set();
        }
    }
}
