package com.example.cancer.demo.letcode.code394;

import com.sun.jmx.remote.internal.ArrayQueue;
import org.springframework.util.StringUtils;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @author : linkc
 * @date : 15:38 2020/5/28
 */
public class Solution {

    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        String resultStr = decodeString(s);
        System.out.println(resultStr);
    }

    /**
     * @param s
     * @return
     */
    private static String decodeString(String s){Stack<String> stack=new Stack<String>();
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)==']') {
                String string="";
                while(!stack.peek().equals("[")) {
                    string=stack.pop()+string;
                }
                stack.pop();

                String countString="";
                while((!stack.isEmpty())&&(stack.peek().charAt(0)>='0'&&stack.peek().charAt(0)<='9')) {
                    countString=stack.pop()+countString;
                }
                int count=Integer.parseInt(countString);

                String retString="";
                for(int j=0;j<count;j++) {
                    retString=retString+string;
                }
                stack.push(retString);
            } else {
                String str=""+s.charAt(i);
                stack.push(str);
            }
        }

        String aaa="";
        while(!stack.isEmpty()) {
            aaa=stack.pop()+aaa;
        }
        return aaa;
    }

}
