package com.practice.simple;

import java.util.*;

/**
 * Description leetcode 【算法 21题 合并两个有序链表】
 * Created by SkillingYu on 2021/10/9 15:14
 */
public class Leetcode_0021 {

    /**
     * 题目描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * 题目来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists/
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(2,new ListNode(5,new ListNode(6)));
        ListNode listNode2 = new ListNode(3,new ListNode(4,new ListNode(8)));
//        ListNode listNode1 = null;
//        ListNode listNode2 = null;
        ListNode listNode = mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode==null?"[]":listNode.toString());
    }


    /**
     * 思路是先将两个升序链表 放到一个集合里，然后对集合排序为升序，在将排序后的集合遍历放到一个新的链表中返回
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> list = new ArrayList<>();
        while(l1!=null){
            int val = l1.val;
            list.add(val);
            l1=l1.next;
        }
        while(l2!=null){
            int val = l2.val;
            list.add(val);
            l2=l2.next;
        }
        ListNode listNode = null;
        if (!list.isEmpty()){
            Collections.sort(list);
            for (int i = list.size()-1; i >=0 ; i--) {
                listNode = i==list.size()-1 ? new ListNode(list.get(i)) : new ListNode(list.get(i), listNode);
            }
        }
        return listNode;
    }

    /** leetcode官方解题  通过递归判断的方式 */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
