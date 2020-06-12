package com.example.cancer.demo.algorithm.sort.bubble.optimize;

import com.example.cancer.demo.util.ArrayUtil;

/**
 * 冒泡排序优化方案一：
 *       加个flag，在某一趟排序中若没有发生元素的交换则说明数组已经是有序数组
 * @author : linkc
 * @date : 9:44 2020/5/25
 */
public class OptimizeBubbleSortPlanA {

    public static void optimizeBubbleSort(int array[]){
        if(ArrayUtil.isEmpty(array)){
            return;
        }
        int length = array.length;
        boolean flag = true;
        //比较次数
        int compareTimes = 0;
        //排序趟数
        int sortTimes = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length-i-1; j++) {
                if(array[j] > array[j+1]){
                    int temp = 0;
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = false;
                    compareTimes++;
                }
            }
            if(flag){
                break;
            }
            sortTimes ++;
        }
        System.out.println(" OptimizeBubble-->CompareTimes: " + compareTimes);
        System.out.println(" OptimizeBubble-->SortTimes: " + sortTimes);
    }
}
