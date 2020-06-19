package com.example.cancer.demo.letcode.code1014;

import java.util.Arrays;

/**
 * 给定正整数数组 A，A[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的距离为 j - i。
 * 一对景点（i < j）组成的观光组合的得分为（A[i] + A[j] + i - j）：景点的评分之和减去它们两者之间的距离。
 * 返回一对观光景点能取得的最高分。
 *
 * 示例：
 * 输入：[8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
 *  
 * 提示：
 * 2 <= A.length <= 50000
 * 1 <= A[i] <= 1000
 *
 * @author : linkc
 * @date : 20:32 2020/6/17
 */
public class MaxScoreSightseeingPair {

    public static void main(String[] args) {
        int A[] = {8,1,5,2,6};
        System.out.println(maxScoreSightseeingPairPlus(A));
    }

    /**
     * 时间复杂度：O(N)
     * @param A
     * @return
     */
    private static int maxScoreSightseeingPairPlus(int A[]){
        int ans = 0, mx = A[0] + 0;
        for (int j = 1; j < A.length; ++j) {
            ans = Math.max(ans, mx + A[j] - j);
            // 边遍历边维护
            mx = Math.max(mx, A[j] + j);
        }
        return ans;
    }


    /**
     * 时间复杂度：O(N^2)
     * @param A
     * @return
     */
    public static int maxScoreSightseeingPair(int A[]){
        int length = A.length;
        if(length==0){
            return 0;
        }else if(length==2){
            return A[0]+A[1]-1;
        }
        int maxNum = 0;
        int tempNum = 0;
        for (int i = 0; i < length-1; i++) {
            for (int j = i+1; j < length; j++) {
                tempNum = A[i]+A[j]+i-j;
                if(maxNum == 0 || tempNum>maxNum){
                    maxNum = tempNum;
                }
            }
        }
        return maxNum;
    }
}
