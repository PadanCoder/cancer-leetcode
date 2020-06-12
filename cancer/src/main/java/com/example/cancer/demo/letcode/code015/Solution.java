package com.example.cancer.demo.letcode.code015;

import java.util.*;

/**
 * @author : linkc
 * @date : 20:03 2020/5/9
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 * 示例：
 * -4,-1,-1,0,1,2,4
 * 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */
public class Solution {

    public static void main(String[] args) {
        int nums[] = {-1, 0, 1, 2, -1, -4,4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums){
        int length = nums.length;
        if(nums.length==0 || nums==null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> ls = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < length-2; i++) {
            if(i==0 || nums[i] != nums[i-1] ){
                int l = i + 1, r = nums.length - 1, sum = 0 - nums[i];
                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        l++;
                        r--;
                    } else if (nums[l] + nums[r] < sum) {
                        while (l < r && nums[l] == nums[l + 1]) l++;   // 跳过重复值
                        l++;
                    } else {
                        while (l < r && nums[r] == nums[r - 1]) r--;
                        r--;
                    }
                }
            }

        }
        return ls;
    }

    /**
     * @Author: linkc
     * @Description: 时间复杂度较高 O(N^3)
     */
     public static List<List<Integer>> threeSumSolutionA(int[] nums) {
        if(nums.length==0 || nums==null){
            return new ArrayList<List<Integer>>();
        }
        int length = nums.length;
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> tempList ;

        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                for (int k = j+1; k < length; k++) {
                    if(nums[i]+nums[j]+nums[k] == 0){
                        tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        list.add(tempList);
                        break;
                    }
                }
            }
        }

        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        for (List<Integer> temp:list) {
            if(!resultList.contains(temp)){
                resultList.add(temp);
            }
        }
        return resultList;
    }
}
