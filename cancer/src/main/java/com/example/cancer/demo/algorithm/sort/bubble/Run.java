package com.example.cancer.demo.algorithm.sort.bubble;

import com.example.cancer.demo.algorithm.sort.bubble.optimize.OptimizeBubbleSortPlanA;
import com.example.cancer.demo.algorithm.sort.bubble.simple.SimpleBubbleSort;
import com.example.cancer.demo.util.ArrayUtil;
import com.example.cancer.demo.util.Exception.ArrayException;

/**
 * @author : linkc
 * @date : 9:43 2020/5/25
 */
public class Run {

    public static void main(String[] args) {
        int[] test = ArrayUtil.getRandomArrayBySizeAndRange(0,100);
        int[] randomArray = ArrayUtil.getRandomArrayBySizeAndRange(10, 100);
        System.out.println(" Before sort: ");
        ArrayUtil.showArray(randomArray);
        //基本实现
        //SimpleBubbleSort.sort(randomArray);
        //优化方案一
        //OptimizeBubbleSortPlanA.optimizeBubbleSort(a);

        System.out.println(" After sort: ");
        ArrayUtil.showArray(randomArray);
    }
}
