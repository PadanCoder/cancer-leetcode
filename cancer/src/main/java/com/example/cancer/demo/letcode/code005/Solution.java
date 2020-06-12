package com.example.cancer.demo.letcode.code005;

/**
 *给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 *示例 1：
 *输入: "babad"
 *输出: "bab"
 *注意: "aba" 也是一个有效答案。
 *
 *示例 2：
 *输入: "cbbd"
 *输出: "bb"
 *
 * @author : linkc
 * @date : 17:54 2020/5/21
 */
public class Solution {

    public static void main(String[] args) {

    }

    /**
     * STEP.1
     * STEP.2
     * STEP.3
     * STEP.4
     * STEP.5
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String resultStr = null;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int head = s.indexOf(chars[i]);
            int last = s.lastIndexOf(chars[i]);
            if(head==last){
                break;
            }
            String tempStr = s.substring(head, last + 1);
            boolean isOdd = tempStr.length()%2==0?true:false;
            int size=0,tempSize=0;
            String str1 = null,str2 = null;
            if(isOdd){
                str1 = tempStr.substring(0, tempStr.length() / 2 + 1);
                str2 = tempStr.substring(tempStr.length()/2,tempStr.length()+1);
            }else{
                str1 = tempStr.substring(0,tempStr.length()/2);
                str2 = tempStr.substring(tempStr.length()/2-1,tempStr.length());
            }
            if(new StringBuilder(str1).reverse().toString().equals(str2)){
                tempSize = tempStr.length();
                if(tempSize>=size){
                    size = tempSize;
                    resultStr = tempStr;
                }
            }
        }
        return null;
    }
}
