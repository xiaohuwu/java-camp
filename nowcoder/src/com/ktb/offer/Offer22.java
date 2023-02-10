package com.ktb.offer;


/**
 * 剑指 Offer 22. 链表中倒数第 k 个节点 - 解决方案
 */
public class Offer22 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        ListNode node6 = new ListNode(6, node5);
        ListNode node7 = new ListNode(7, node6);
        print(node7);
        ListNode node = getKthFromEnd(node7, 2);
        System.out.println("node.toString() = " + node.toString());
    }

    private static ListNode getKthFromEnd(ListNode head, int index) {
        ListNode pre = head;
        ListNode post = head;
        for (int i = 0; i < index; i++) {
            post = post.next;
        }
        while (post != null) {
            int val = post.getVal();
            System.out.print(val + "-->");
            post = post.next;
            pre = pre.next;
        }
        return pre;
    }

    private static void print(ListNode node1) {
        ListNode current = node1;
        while (current != null) {
            int val = current.getVal();
            System.out.print(val + "-->");
            current = current.next;
        }
    }

}
