package com.example.cancer.demo.multiplethread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;


public class CyclicBarrierTest {


    static class MyThread implements Runnable{
        CyclicBarrier cyclicBarrier;
        String name;
        public MyThread(CyclicBarrier cyclicBarrier,String name){
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name);
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("齐活了");
        });

        List<MyThread> list = new ArrayList<MyThread>();

        for (int i = 0; i < 15; i++) {
            list.add(new MyThread(cyclicBarrier,i + ""));
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (MyThread myThread:list) {
            executorService.submit(myThread);
        }
    }

}
