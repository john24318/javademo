package demo.java.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Warehouse warehouse = new Warehouse();
        Producer p1 = new Producer("p1", warehouse);
        Producer p2 = new Producer("p2", warehouse);
        Producer p3 = new Producer("p3", warehouse);
        Consumer c1 = new Consumer("c1", warehouse);
        Consumer c2 = new Consumer("c2", warehouse);

        System.out.println("测试开始！");
        p1.start();
        p2.start();
        p3.start();
        c1.start();
        c2.start();
    }
}

/**
 * 生产者
 * 
 * @author wangyao
 * 
 */
class Producer extends Thread {
    Warehouse warehouse;
    String name; // 生产者名字
    Random random = new Random();
    long sequence = 0; // 产品序号

    public Producer(String name, Warehouse warehouse) {
        super(name);
        this.name = name;
        this.warehouse = warehouse;
    }

    public void run() {
        while (true) {
            try {
                sleep(random.nextInt(10001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String product = name + ":" + (++sequence);
            System.out.println("生产产品 " + product);
            warehouse.put(product);
        }
    }
}

/**
 * 消费者
 * 
 * @author wangyao
 * 
 */
class Consumer extends Thread {
    Warehouse warehouse;
    String name;
    Random random = new Random();

    public Consumer(String name, Warehouse warehouse) {
        super(name);
        this.name = name;
        this.warehouse = warehouse;
    }

    public void run() {
        while (true) {
            try {
                sleep(random.nextInt(10001));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            String product = warehouse.get().toString();
            System.out.println("消耗产品 " + product + ":" + name);
        }
    }
}

/**
 * 仓库
 * 
 * @author wangyao
 * 
 */
class Warehouse {
    private List<Object> list;
    private int maxSize;

    public Warehouse() {
        super();
        list = new ArrayList<Object>();
        maxSize = 10;
    }

    public Warehouse(List<Object> list, int maxSize) {
        super();
        this.list = list;
        this.maxSize = maxSize;
    }

    /**
     * 产品入库
     * 
     * @param o
     */
    public synchronized void put(Object o) {
        // 此处必须用while，当线程被唤醒时，仍需再次检查条件
        while (list.size() >= maxSize) {
            try {
                System.out.println("仓库已满，请稍后！");
                wait(); // 在其他线程调用此对象的 notify() 方法或 notifyAll() 方法前，导致当前线程等待。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        list.add(o);
        System.out.println(o + "已入库！" + list.size());
        notifyAll(); // 唤醒在此对象监视器上等待的所有线程。线程通过调用其中一个 wait 方法，在对象的监视器上等待。直到当前线程放弃此对象上的锁定，才能继续执行被唤醒的线程。

    }

    /**
     * 产品出库
     * 
     * @return
     */
    public synchronized Object get() {
        Object ret = null;

        // 此处必须用while，当线程被唤醒时，仍需再次检查条件
        while (list.size() < 1) {
            try {
                System.out.println("仓库已空，请稍后！");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ret = list.remove(0);
        System.out.println(ret + "已出库！" + list.size());
        notifyAll();

        return ret;
    }
}