package com.ktb.leetcode.linklist;


public class ReverseList {

    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);
        print(one);
        System.out.println();
        ListNode listNode = reverseList(one);
        print(listNode);
    }

    public static void print( ListNode head) {
       while (head != null){
           System.out.print(head.getVal()+"---->");
           head = head.getNext();
       }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode pre = null;
        ListNode temp;
        while (current != null){
            temp = current.next; //临时变量保存下一个节点的位置
            current.next = pre ;  //当前节点指向上一个节点
            pre = current;
            current = temp;
        }
        return pre;
    }


}
