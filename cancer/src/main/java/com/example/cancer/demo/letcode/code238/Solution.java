package com.example.cancer.demo.letcode.code238;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，
 * 其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *
 * 示例:
 * 输入: [1,2,3,4]
 * 输出: [24,12,8,6]
 *  
 * 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @author : linkc
 * @date : 18:10 2020/6/4
 */
public class Solution {

    public static void main(String[] args) {
         int nums[] = {1,2,3,4};
        int[] answer = productExceptSelf(nums);

        Arrays.asList(answer).stream().forEach(a -> System.out.println(a));
    }

    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int result[] = new int[length];
        int left[] = new int[length];
        int right[] = new int[length];
        left[0] = 1;
        for (int i = 1; i < length; i++) {
           left[i] = nums[i-1] * left[i-1];
        }
        right[length-1] = 1;
        for (int i = length-2; i >=0 ; i--) {
            right[i] = nums[i+1] * right[i+1];
        }

        for (int i = 0; i < length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }


}
