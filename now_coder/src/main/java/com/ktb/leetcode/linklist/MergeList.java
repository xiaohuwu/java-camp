package com.ktb.leetcode.linklist;

import com.ktb.offer.ListNode;

public class MergeList {

    public static void main(String[] args) {
        ListNode five = new ListNode(8);
        ListNode four = new ListNode(6, five);
        ListNode three = new ListNode(4, four);

        print(three);
        System.out.println();


        ListNode five_1 = new ListNode(7);
        ListNode four_1 = new ListNode(5, five_1);
        ListNode three_1 = new ListNode(3, four_1);

        print(three_1);
        System.out.println();

        ListNode listNode = mergeTwoLists(three, three_1);
        print(listNode);
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.getVal() + "---->");
            head = head.getNext();
        }
    }

    public static ListNode mergeTwoLists(ListNode head, ListNode other) {
        ListNode insert = null;
        while (head != null) {
            System.out.print(head.getVal() + "---->");
            insert = insert(head, other);
            head = head.getNext();
        }
        return insert;
    }

    private static ListNode insert(ListNode param, ListNode other) {
        ListNode head = other;
        if (param.getVal() <= other.getVal()) {
            param.next = other;
            head = param;
        } else {
            while (other != null) {
                if (param.getVal() < other.getNext().getVal() &&  param.getVal() >= other.getVal()) {
                    param.next = other.getNext();
                    other.next = param;
                } else {
                    other = other.getNext();
                }
            }
        }
        return head;
    }

}
