package com.example.cancer.demo.letcode.code739;

import org.apache.poi.ss.formula.functions.T;

import java.util.Stack;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 * 如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : linkc
 * @date : 9:45 2020/6/11
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int arr[] = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperatures(arr);
        for (Integer a:result) {
            System.out.println(a);
        }
    }

    /**
     * 暴力解法
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T) {
        int length = T.length;
        int count=1;
        int result[] = new int[length];
        for (int i = 0; i < length; i++) {
            if(i==length-1){
                result[length-1] = 0;
                break;
            }
            for (int j = i+1; j < length; j++) {
                if(T[i]<T[j]){
                    break;
                }else{
                    if(j==length-1){
                        count=0;
                    }else{
                        count++;
                    }
                }
            }
            result[i] = count;
            count = 1;
        }
        return result;
    }

    /**
     * 单调栈解法
     * @param T
     * @return
     */
    public static int[] monotoneStack(int[] T){
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[T.length];
        for(int i = 0; i < T.length; ++i){
            while(!stack.isEmpty() && T[i] > T[stack.peek()]){
                int temp = stack.pop();
                res[temp] = i - temp;
            }
            stack.push(i);
        }
        return res;
    }
}
