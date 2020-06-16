package com.example.cancer.demo.letcode.code165;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 比较两个版本号 version1 和 version2。
 * 如果 version1 > version2 返回 1，如果 version1 < version2 返回 -1，
 * 除此之外返回 0。
 *
 * 你可以假设版本字符串非空，并且只包含数字和 . 字符。
 *
 *  . 字符不代表小数点，而是用于分隔数字序列。
 *
 * 例如，2.5 不是“两个半”，也不是“差一半到三”，而是第二版中的第五个小版本。
 *
 * 你可以假设版本号的每一级的默认修订版号为 0。例如，版本号 3.4 的第一级（大版本）和第二级（小版本）修订号分别为 3 和 4。
 * 其第三级和第四级修订号均为 0。
 *  
 *
 * 示例 1:
 *
 * 输入: version1 = "0.1", version2 = "1.1"
 * 输出: -1
 * 示例 2:
 *
 * 输入: version1 = "1.0.1", version2 = "1"
 * 输出: 1
 * 示例 3:
 *
 * 输入: version1 = "7.5.2.4", version2 = "7.5.3"
 * 输出: -1
 * 示例 4：
 *
 * 输入：version1 = "1.01", version2 = "1.001"
 * 输出：0
 * 解释：忽略前导零，“01” 和 “001” 表示相同的数字 “1”。
 * 示例 5：
 *
 * 输入：version1 = "1.0", version2 = "1.0.0"
 * 输出：0
 * 解释：version1 没有第三级修订号，这意味着它的第三级修订号默认为 “0”。
 *  
 *
 * 提示：
 *
 * 版本字符串由以点 （.） 分隔的数字字符串组成。这个数字字符串可能有前导零。
 * 版本字符串不以点开始或结束，并且其中不会有两个连续的点。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compare-version-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author : linkc
 * @date : 11:25 2020/6/16
 */
public class CompareVersion {

    public static void main(String[] args) {
        //System.out.println("7.5.4".replace(".",""));
        System.out.println(compareVersion("1","1.10"));
    }

    public static int compareVersion(String version1, String version2) {
        int result = 0;
        Boolean flag = version1.length()<version2.length()?true:false;
        int count=0;
        if(ifAdd(version1,version2)){
            int a = getCounts(version1);
            int b = getCounts(version2);
            if(flag){
                for (int i = 0; i < b-a; i++) {
                    version1+=".0";
                }
            }else{
                for (int i = 0; i < a-b; i++) {
                    version2+=".0";
                }
            }
        }
        int v1 = tranToNum(version1);
        int v2 = tranToNum(version2);
        System.out.println("v1 ：" + v1);
        System.out.println("v2 ：" + v2);
        if(v1>v2){
            return 1;
        }else if(v1<v2){
            return -1;
        }
        return result;
    }
    
    private static int tranToNum(String str){
        int result = 0;
        String[] arr = str.split("\\.");
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            String tempStr = arr[i];
            if(i==0&&tempStr.equals("0")){
                continue;
            }
            Integer integer = Integer.valueOf(tempStr);
            int temp = (int) (Math.pow(10,length-1-i)*integer);
            result+=temp;
        }
        return result;
    }

    private static boolean ifAdd(String str1, String str2){
        return getCounts(str1)==getCounts(str2)?false:true;
    }

    private static int getCounts(String str){
        int count = str.length()-str.replace(".","").length();
        return count;
    }
}
