package com.example.cancer.demo.util;

import com.example.cancer.demo.util.Exception.ArrayException;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;

/**
 * 数组工具类
 * @author : linkc
 * @date : 9:48 2020/5/25
 */
@Slf4j
public class ArrayUtil {

    /**
     * 判断数组是否为空
     * @param a
     * @return
     */
    public static boolean isEmpty(int a[]){
        return a==null || a.length==0 ? true: false;
    }

    /**
     * 生成size个随机数，范围为0~range
     * @param size
     * @param range
     * @return
     */
    public static int[] getRandomArrayBySizeAndRange(int size,int range){
        int array[];
        if(size<=0){
            log.info("ArrayUtil-->getRandomArrayBySizeAndRange:size can not less than or equals zero!");
            throw new ArrayException.EmptyException("Array is empty!");
        }
        if(size == 0){
            array = new int[0];
            return array;
        }
        array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(range);
        }
        return array;
    }

    /**
     *打印数组内容
     */
    public static void showArray(int array[]){
        if(isEmpty(array)){
            return;
        }
        for (int a: array) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
