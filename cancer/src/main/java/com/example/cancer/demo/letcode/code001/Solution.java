package com.example.cancer.demo.letcode.code001;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * Related Topics 数组 哈希表
 *
 * @author : linkc
 * @date : 19:09 2020/5/20
 */
public class Solution {

    public static void main(String[] args) {
        int nums[] = {11, 15,2,7};
        int[] ints = twoSum(nums, 17);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        int result[] = new int[2];
        int length = nums.length;
        boolean flag = false;
        for (int i = 0; i < length; i++) {
             int j = i+1;
             int temp = nums.length;
             while(j<temp){
                 if(nums[i]+nums[j]==target){
                      result[0] = i;
                      result[1] = j;
                      flag = true;
                      break;
                 }else{
                     j++;
                 }
             }
             if(flag){
                break;
             }
        }
        return result;
    }
}
