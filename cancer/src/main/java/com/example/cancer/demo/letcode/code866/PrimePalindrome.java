package com.example.cancer.demo.letcode.code866;

import java.util.Stack;

/**
 * 求出大于或等于 N 的最小回文素数。
 *
 * 回顾一下，如果一个数大于 1，且其因数只有 1 和它自身，那么这个数是素数。
 *
 * 例如，2，3，5，7，11 以及 13 是素数。
 *
 * 回顾一下，如果一个数从左往右读与从右往左读是一样的，那么这个数是回文数。
 *
 * 例如，12321 是回文数。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：6
 * 输出：7
 * 示例 2：
 *
 * 输入：8
 * 输出：11
 * 示例 3：
 *
 * 输入：13
 * 输出：101
 *  
 *
 * 提示：
 *
 * 1 <= N <= 10^8
 * 答案肯定存在，且小于 2 * 10^8。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/prime-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : linkc
 * @date : 20:22 2020/6/11
 */
public class PrimePalindrome {

    public static void main(String[] args) {
        //System.out.println(primePalindrome(13));

        System.out.println(isPrimePlus(121));
    }

    private static int primePalindrome(int N){
        int result=N;
        boolean flag = true;
        while(flag){
            if(isPrime(result) && isPalindrome2(result)){
                flag = false;
                break;
            }
            result++;
        }
        return result;
    }

    /**
     * 素数判断：常规方法
     * @param num
     * @return
     */
    private static boolean isPrime(int num){
        if(num<2){
            return false;
        } if(num==2 ||num==3){
            return true;
        }else{
            double sqrt = Math.sqrt(num);
            for (int i = 2; i <= sqrt; i++) {
                if(num%i==0){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * 素数判断变态版：6倍原理
     * @param num
     * @return
     */
    private static boolean isPrimePlus(int num){

        if(num<2) {
            return false;
        }
        if(num==2 ||num == 3|| num==5){
            return true;
        }
        if(num%2==0 || num%3==0){
            return false;
        }

        for (int i = 6; i <= Math.sqrt(num); i+=6) {
            if(num%(i-1) ==0 || num %(i+1)==0){
                return false;
            }
        }
        
        return true;
    }


    private static boolean isPalindrome(int num){
        String str = String.valueOf(num);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
        String pStr = "";
        while(!stack.isEmpty()){
            pStr+=String.valueOf(stack.pop());
        }
        if(str.equals(pStr)){
            return true;
        }
        return false;
    }

    private static boolean isPalindrome2(int num){
        String str = String.valueOf(num);
        for (int i = 0; i < str.length()/2; i++) {
            if(!String.valueOf(str.charAt(i)).equals(String.valueOf(str.charAt(str.length()-i-1)))){
                return false;
            }
        }
        return true;
    }


}
