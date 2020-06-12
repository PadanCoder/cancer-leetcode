package com.example.cancer.demo.letcode.code003;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * @author : linkc
 * @date : 17:55 2020/5/21
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }else if(s.equals(" ") || s.length() ==1){
            return 1;
        }
        int count = 1;
        int maxLength = 1;
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length-i; j++) {
                String substring = s.substring(i, i+j+1);
                char c = substring.charAt(substring.length() - 1);
                int tempIndex = substring.indexOf(c);
                if(tempIndex != substring.length()-1){
                    if(count >maxLength){
                        maxLength = count;
                    }
                    count = 1;
                    break;
                }
                count++;
            }
            maxLength = count>maxLength?count:maxLength;
            count = 1;
        }
        return maxLength;
    }
}
