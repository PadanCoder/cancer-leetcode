package com.example.cancer.demo.letcode.code014;

import org.springframework.util.StringUtils;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 *
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : linkc
 * @date : 10:39 2020/6/15
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {

        String[] strs = {"flower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length==0){
            return "";
        }
        String tempStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if(tempStr.length()==0){
                break;
            }
            while(strs[i].indexOf(tempStr)!=0){
                tempStr = tempStr.substring(0,tempStr.length()-1);
            }
        }
        return tempStr;
    }

}


