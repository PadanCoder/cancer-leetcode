package com.example.cancer.demo.letcode.interview.code046;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，
 * 25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 * 提示：
 * 0 <= num < 231
 *
 * 动态规划转移方程
 * @author : linkc
 * @date : 10:18 2020/6/5
 */
public class Solution {

    public static void main(String[] args) {
        int count1 = translateNum(122);
        int count2 = mySolution(122);
        System.out.println(count1);
        System.out.println(count2);
    }

    public static int translateNum(int num) {
        String src = String.valueOf(num);
        int p = 0, q = 0, r = 1;
        for (int i = 0; i < src.length(); ++i) {
            p = q;
            q = r;
            r = 0;
            r += q;
            if (i == 0) {
                continue;
            }
            String pre = src.substring(i - 1, i + 1);
            if (pre.compareTo("25") <= 0 && pre.compareTo("10") >= 0) {
                r += p;
            }
        }
        return r;
    }

    //12258
    public static int mySolution(int num){
        int count=0;
        String numStr = String.valueOf(num);
        for (int i = 0; i < numStr.length(); i++) {
            if(i==0){
                count++;
                continue;
            }
            String tempStr = numStr.substring(i-1,i+1);
            if(tempStr.compareTo("25")<=0 && tempStr.compareTo("10")>=0){
                count++;
            }
            if(i==numStr.length()-1){
                count++;
            }
        }
        return count;
    }
}
