package com.example.cancer.demo.letcode.code016;

import com.sun.activation.registries.MailcapParseException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 示例：
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 *  
 * [-3,-2,-5,3,-4] -1
 * -2
 *
 * [1,2,4,8,16,32,64,128]  82
 * 82
 *
 *
 * [-111,-111,3,6,7,16,17,18,19] 13
 * 16
 *
 * 提示：
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 *
 * @author : linkc
 * @date : 9:54 2020/6/24
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
         int nums[] = {-111,-111,3,6,7,16,17,18,19};
         int target = 13;
         System.out.println(threeSumClosestTry(nums,target));
    }

    public static int threeSumClosestTry(int[] nums, int target){
        if(nums.length == 3){
            return nums[0]+nums[1]+nums[2];
        }
        Arrays.sort(nums);
        int length = nums.length;
        int minAbs = Math.abs(nums[0] + nums[1] + nums[length-1]-target);
        int minSum = nums[0]+nums[1]+nums[length-1];
        int result = minSum;
        for (int i = 0; i < length-2; i++) {
            int a = nums[i];
            int l = i+1;
            int r = length-1;
            while(l<r){
                int tempMinSum = a+nums[l]+nums[r];
                int tempMinAbs = Math.abs(tempMinSum-target);
                if(tempMinSum == target){
                    return target;
                }else if(tempMinSum>target){
                    if(tempMinAbs<minAbs){
                        minSum = tempMinSum;
                        minAbs = tempMinAbs;
                    }
                    r--;
                }else {
                    if(tempMinAbs<minAbs){
                        minSum = tempMinSum;
                        minAbs = tempMinAbs;
                    }
                    l++;
                }
            }
        }
        return minSum;
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums.length == 3){
            return nums[0]+nums[1]+nums[2];
        }
        int minAbs = Math.abs(nums[0] + nums[1] + nums[2]-target);
        int minSum = nums[0]+nums[1]+nums[2];
        int result = minSum;
        for (int i = 1; i < nums.length-1; i++) {
            int a = nums[i-1];
            int b = nums[i];
            int tempSum = a+b;
            for (int j = i+1; j < nums.length; j++) {
                int c = nums[j];
                int tempMinSum = tempSum+c;
                int tempMinAbs = Math.abs(tempMinSum-target);
                if(tempMinAbs<minAbs){
                    minAbs = tempMinAbs;
                    result = tempMinSum;
                }
            }
        }
        return result;
    }
}
