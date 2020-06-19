package com.example.cancer.demo.letcode.code125;

import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 *
 * @author : linkc
 * @date : 9:38 2020/6/19
 */
public class IsPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindromePlus(s));
    }

    public static boolean isPalindrome(String s) {
        if(StringUtils.isEmpty(s)){
            return false;
        }
        String replaceStr = s.replace(" ", "");
        Stack<String> stack = new Stack<String>();
        char[] charArr = replaceStr.toCharArray();
        String originStr = "";
        for (int i = 0; i < charArr.length; i++) {
            if(Character.isLetterOrDigit(charArr[i])){
                String tempStr = String.valueOf(charArr[i]).toUpperCase();
                originStr+=tempStr;
                stack.push(tempStr);
            }
        }
        String reversalStr = "";
        while(!stack.isEmpty()){
            reversalStr += stack.pop();
        }
        if(originStr.equals(reversalStr)){
            return true;
        }
        return false;
    }

    public static boolean isPalindromePlus(String s){
        if(s==null ||s.length()==0){
            return true;
        }
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                str.append(String.valueOf(s.charAt(i)).toUpperCase());
            }
        }
        StringBuilder reverse = new StringBuilder(str).reverse();
        if(str.toString().equals(reverse.toString())){
            return true;
        }
        return false;
    }
}
