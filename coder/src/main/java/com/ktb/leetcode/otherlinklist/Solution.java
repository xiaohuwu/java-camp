package com.ktb.leetcode.otherlinklist;

public class Solution {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        printNode(one);
        ListNode listNode = reverseList(one);
        printNode(listNode);
    }

    /**
     * 反转链表 差点我就写出来了，不知道怎么访问前一个节点
     * 反转链表 本质需要当前节点指向前一个节点
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }


    private static void printNode(ListNode one) {
        ListNode current = one;
        while (current != null) {
            System.out.print(current.getVal() + "->");
            current = current.getNext();
        }
        System.out.println();
    }


}
