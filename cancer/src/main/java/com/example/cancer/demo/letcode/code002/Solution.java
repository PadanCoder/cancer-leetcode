package com.example.cancer.demo.letcode.code002;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 *  * Definition for singly-linked list.
 *  * public class ListNode {
 *  *     int val;
 *  *     ListNode next;
 *  *     ListNode(int x) { val = x; }
 *  * }
 *
 * @author : linkc
 * @date : 20:19 2020/5/20
 */
public class Solution {

    public static void main(String[] args) {
        long arr1[] = {9};
        long arr2[] = {1,9,9,9,9,9,9,9,9,9};
        ListNode listNode1 = tranArrToListNode(arr1);
        ListNode listNode2 = tranArrToListNode(arr2);
        ListNode listNodeResult = addTwoNumbers(listNode1, listNode2);
        showListNode(listNodeResult);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        BigDecimal result1 = getResult(l1);
        BigDecimal result2 = getResult(l2);
        BigDecimal result = result1.add(result2);
        String str = result.toString();
        char[] chars = str.toCharArray();
        Stack<Integer> stack = new Stack<Integer>();
        for (Character c:chars) {
            stack.push(Integer.valueOf(c.toString()));
        }
        ListNode resultListNode = new ListNode(stack.pop());
        ListNode tempResult =  resultListNode;
        ListNode tempListNode = null;
        while(!stack.isEmpty()){
            tempListNode = new ListNode(stack.pop());
            tempResult.next = tempListNode;
            tempResult = tempResult.next;
        }
        return resultListNode;
    }

    public static BigDecimal getResult(ListNode listNode){
        BigDecimal result = new BigDecimal(0);
        BigDecimal temp = new BigDecimal(1);
        ListNode tempListNode = listNode;
        BigDecimal tempDe = null;
        while(tempListNode != null){
            tempDe = temp.multiply(new BigDecimal(tempListNode.val));
            result = result.add(tempDe);
            temp = temp.multiply(new BigDecimal(10));
            tempListNode = tempListNode.next;
        }
        return result;
    }

    public static void showListNode(ListNode listNode){
        ListNode temp = listNode;
        String result = " ";
        while(temp!=null){
            result = result + temp.val + " -> ";
            temp = temp.next;
        }
        System.out.println(result.substring(0,result.length()-4));
    }

    public static ListNode tranArrToListNode(long arr[]){
        ListNode head = new ListNode(Integer.valueOf(String.valueOf(arr[0])));
        ListNode listNode = head;
        ListNode temp;
        for (int i = 1; i < arr.length; i++) {
            temp = new ListNode(Integer.valueOf(String.valueOf(arr[i])));
            listNode.next = temp;
            listNode = listNode.next;
        }
        return head;
    }
}
