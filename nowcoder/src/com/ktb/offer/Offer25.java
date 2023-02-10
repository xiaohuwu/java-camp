package com.ktb.offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 */

public class Offer25 {
    public static void main(String[] args) {
        ListNode node7 = new ListNode(7);
        ListNode node5 = new ListNode(5, node7);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);
        print(node1);

        ListNode node8 = new ListNode(8);
        ListNode node6 = new ListNode(6, node8);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);
        print(node2);

        ListNode node = mergeTwoList(node1, node2);
        print(node);
    }

    private static ListNode mergeTwoList(ListNode node1, ListNode node2) {
        ListNode l1 = node1;
        ListNode l2 = node2;
        ListNode head = new ListNode(-1);
        ListNode current = head;
        while (l1 != null && l2 != null) {
            if (l1.getVal() < l2.getVal()) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if (l1 == null) {
            current.next = l2;
        }
        if (l2 == null) {
            current.next = l1;
        }
        return head.next;
    }

    private static void print(ListNode node1) {
        ListNode current = node1;
        while (current != null) {
            int val = current.getVal();
            System.out.print(val + "-->");
            current = current.next;
        }
        System.out.println();
    }

}
