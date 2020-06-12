package com.example.cancer.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {


    }


    @Test
    public void test1(){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("ready...");
        });
        ExecutorService executorService = Executors.newFixedThreadPool(15);
        Random random = new Random();
        List<Future<List<Integer>>> futureList = new ArrayList<Future<List<Integer>>>();
        for (int i = 0; i < 20; i++) {
            FutureTask<List<Integer>> futureTask = (FutureTask<List<Integer>>) executorService.submit(()->{
                System.out.println("Thread-" + Thread.currentThread().getName());
                List<Integer> tempList = new ArrayList<>();
                for (int j = 0; j < 100; j++) {
                    int randomNum = random.nextInt(10000);
                    tempList.add(randomNum);
                }
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                return tempList;
            });
            futureList.add(futureTask);
        }

    }

    @Test
    public void testSqrt(){
        Long a = 9999999991l + 1410065408l;
        System.out.println(a);
    }

    public int sqrt(int x){
        if(x==1){
            return 1;
        }
        int min = 1;
        int max = x;

        while(max-min>1){
            int middle = (max+min)/2;
            if(x/middle<middle){
                max = middle;
            }else{
                min = middle;
            }
        }
        return min;
    }
}
