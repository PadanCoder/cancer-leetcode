package com.example.cancer.demo.letcode.code067;

import java.util.Stack;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *  
 *
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 *
 * 1111   1111 11110
 * @author : linkc
 * @date : 19:50 2020/6/23
 */
public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinaryPlus("1111","1111"));
    }

    public static String addBinary(String a, String b) {
        String str = "";
        int tempCount;
        String sb = "0";
        if(a.length()>b.length()){
            tempCount = a.length()-b.length();
            for (int i = 0; i < tempCount; i++) {
                b=sb+b;
            }
        }else if(a.length()<b.length()){
            tempCount = b.length()-a.length();
            for (int i = 0; i < tempCount; i++) {
                a = sb+a;
            }
        }
        Stack<String> stack = new Stack<String>();
        Integer stackInt=0;
        int length = a.length();
        for (int i = length-1; i >= 0; i--) {
            int a1 = Integer.valueOf(String.valueOf(a.charAt(i)));
            int b1 = Integer.valueOf(String.valueOf(b.charAt(i)));
            if(a1+b1>1){
                if(stackInt==1){
                    stack.push("1");
                }else{
                    stack.push("0");
                    stackInt = 1;
                }
            }else if(a1+b1==0){
                if(stackInt==1){
                    stack.push("1");
                    stackInt = 0;
                }else{
                    stack.push("0");
                }
            }else if(a1+b1==1){
                if(stackInt==1){
                    stack.push("0");
                    stackInt=1;
                }else{
                    stack.push("1");
                }
            }
            if(i==0 && stackInt==1){
                stack.push("1");
            }
        }

        while(!stack.isEmpty()){
            str+=stack.pop();
        }
        return str;
    }

    public static String addBinaryPlus(String a, String b){
        return  Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
    }
}
