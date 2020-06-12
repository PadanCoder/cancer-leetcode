package com.example.cancer.demo.algorithm.sort.bubble.simple;

import com.example.cancer.demo.util.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序简单实现
 * @author : linkc
 * @date : 9:44 2020/5/25
 */
public class SimpleBubbleSort {

    public static void sort(int a[]){
        if(ArrayUtil.isEmpty(a)){
            return;
        }
        //比较次数
        int compareTimes = 0;
        //排序趟数
        int sortTimes = 0;
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-1-i; j++) {
                if(a[j] > a[j+1]){
                    compareTimes++;
                    int temp = 0;
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
            sortTimes++;
        }
        System.out.println(" SimpleBubbleSort-->CompareTimes : " + compareTimes);
        System.out.println(" SimpleBubbleSort-->SortTimes : " + sortTimes);
    }
}
