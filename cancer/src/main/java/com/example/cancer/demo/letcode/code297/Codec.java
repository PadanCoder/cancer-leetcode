package com.example.cancer.demo.letcode.code297;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，
 * 同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，
 * 你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例: 
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，
 * 你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 *
 * @author : linkc
 * @date : 16:53 2020/6/16
 */
public class Codec {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;
        System.out.println(serialize(treeNode1));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if(root==null){
            result.append("null,");
            return result.toString();
        }
        result.append(root.val+",");
        result.append(serialize(root.left));
        result.append(serialize(root.right));
        return result.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data==null || data.length()==0){
            return null;
        }
        String[] dataArr = data.split(",");
        List<String> list = new ArrayList<String>(Arrays.asList(dataArr));
        TreeNode node = des(list);
        return node;
    }

    private static TreeNode des(List<String> list){
        if(list==null){
            return null;
        }
        if(list.get(0).equals("null")){
            list.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(list.get(0)));
        list.remove(0);
        node.left = des(list);
        node.right = des(list);
        return node;
    }

    private static void middle(TreeNode root, List<String> list){
        if(root==null){
            return;
        }
        int height = getHeight(root);
        list.add(String.valueOf(root.val));

        if(root.left!=null){
            middle(root.left,list);
        }else{
            list.add("null");
        }
        if(root.right!=null){
            middle(root.right,list);
        }else{
            list.add("null");
        }
    }

    private static int getHeight(TreeNode node){
        if(node==null){
            return 0;
        }
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight,rightHeight)+1;
    }
}
