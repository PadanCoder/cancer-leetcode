package com.example.cancer.demo.letcode.interview.code1618;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
 * 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。
 * 但需注意"a"和"b"不能同时表示相同的字符串。编写一个方法判断value字符串是否匹配pattern字符串。
 *
 * 示例 1：
 * 输入： pattern = "abba", value = "dogcatcatdog"
 * 输出： true
 *
 * 示例 2：
 * 输入： pattern = "abba", value = "dogcatcatfish"
 * 输出： false
 *
 * 示例 3：
 * 输入： pattern = "aaaa", value = "dogcatcatdog"
 * 输出： false
 *
 * 示例 4：
 * 输入： pattern = "abba", value = "dogdogdogdog"
 * 输出： true
 * 解释： "a"="dogdog",b=""，反之也符合规则
 *
 * 提示：
 * 0 <= len(pattern) <= 1000
 * 0 <= len(value) <= 1000
 * 你可以假设pattern只包含字母"a"和"b"，value仅包含小写字母。
 *
 * "abba"
 * "dogdogdogdog"  这竟然预期结果是true
 * 这题有毒，我放弃了
 * @author : linkc
 * @date : 9:58 2020/6/22
 */
public class PatternMatching {

    public static void main(String[] args) {
        System.out.println(patternMatching("abba","dogdogdogdog"));
    }

    public static boolean patternMatching(String pattern, String value) {
        if((value==null||value.length()==0)){
            if(pattern!=null && pattern.length()!=0){
                if(pattern.length()==1){
                    return true;
                }else if(pattern.charAt(0)!=pattern.charAt(1)){
                    return false;
                }
            }else if(pattern==null||pattern.length()==0){
                return true;
            }
        }
        if(value.length()!=0){
            if(pattern.length()==0){
                return false;
            }else if(pattern.length()==2 && pattern.charAt(0)!=pattern.charAt(1)){
                return false;
            }
        }
        if("a".equals(pattern)||"b".equals(pattern)||"ab".equals(pattern)){
            return true;
        }
        StringBuilder paStr = new StringBuilder();
        String first = String.valueOf(pattern.charAt(0));
        int count_a = 0;
        int count_b = 0;
        boolean flagPattern = false;
        for (int i = 0; i < pattern.length(); i++) {
            if(String.valueOf(pattern.charAt(i)).equals(first)){
                paStr.append("true");
            }else {
                paStr.append("false");
            }
            if(pattern.charAt(i)=='a'){
                count_a++;
            }else{
                count_b++;
            }
        }
        if(count_a==0||count_b==0){
            flagPattern = true;
        }
        List<String> list = new ArrayList<String>();
        for (int i = 0; i <= value.length()-3; i+=3) {
            list.add(value.substring(i,i+3));
        }
        boolean flagValue = false;
        int count1=0;
        int count2=0;
        String tempStr = list.get(0);
        StringBuilder sb = new StringBuilder();
        for (String str: list) {
            if(str.equals(tempStr)){
                sb.append("true");
                count1++;
            }else{
                sb.append("false");
                count2++;
            }
        }

        if(count1==0||count2==0){
            flagValue = true;
        }
        if(flagPattern && flagValue){
            return true;
        }

        return sb.toString().equals(paStr.toString())?true:false;
    }
}
