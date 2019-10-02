package com.epochong.lock.onebyone;

/**
 * @author epochong
 * @date 2019/10/1 23:03
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class Run {
    public static void main(String[] args) {
        Service service = new Service();

        Producer producer = new Producer(service);

        Consumer consumer = new Consumer(service);

        producer.start();
        consumer.start();
    }
}
