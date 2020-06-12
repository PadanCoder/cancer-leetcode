package com.example.cancer.demo.letcode.code1343;

import java.util.Arrays;

/**
 *
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * 请你返回长度为 k 且平均值大于等于 threshold 的连续子数组数目。
 *
 * 示例 1：
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 *
 * 示例 2：
 * 输入：arr = [1,1,1,1,1], k = 1, threshold = 0
 * 输出：5
 *
 * 示例 3：
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 *
 * 示例 4：
 * 输入：arr = [7,7,7,7,7,7,7], k = 7, threshold = 7
 * 输出：1
 *
 * 示例 5：
 * 输入：arr = [4,4,4,4], k = 4, threshold = 1
 * 输出：1
 *  
 * 提示：
 * 1 <= arr.length <= 10^5
 * 1 <= arr[i] <= 10^4
 * 1 <= k <= arr.length
 * 0 <= threshold <= 10^4

 * @author : linkc
 * @date : 18:53 2020/5/27
 */
public class Solution {

    public static void main(String[] args) {
        int arr[] = {4,4,4,4};
        int count = numOfSubarrays(arr, 4, 1);
        System.out.println(count);
    }

    /**
     * @param arr 整形数组
     * @param k 子数组长度
     * @param threshold 子数组平均值最小值
     * @return
     * STEP.1 计算前K个值的和 tempSum
     * STEP.2 判断tempSum/k>=threshold? 若成立，则count++；若不成立则跳过
     * STEP.3 用tempSum减去数组头部的值，再加上尾部后面的值，成为新的tempSum（类似平移）
     * STEP.4 回到STEP.2
     */
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int tempSum = 0;
        for (int i = 0; i < arr.length-k+1; i++) {
            if(tempSum == 0){
                int[] tempArr = Arrays.copyOfRange(arr, i, i+k);
                tempSum = sum(tempArr);
            }
            if(tempSum/k>=threshold){
                count++;
            }
            if(i+k<arr.length){
                tempSum = tempSum-arr[i]+arr[i+k];
            }
        }
        return count;
    }

    private static int sum(int arr[]){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }
        return sum;
    }
}
