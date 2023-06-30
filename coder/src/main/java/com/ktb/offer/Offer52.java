package com.ktb.offer;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 */

public class Offer52 {

    public static void main(String[] args) {

        ListNode node7 = new ListNode(7);
        ListNode node5 = new ListNode(5, node7);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);
        print(node1);

        ListNode node8 = new ListNode(5);
        ListNode node6 = new ListNode(3, node8);
        ListNode node4 = new ListNode(4, node6);
        ListNode node2 = new ListNode(2, node4);
        print(node2);

        ListNode node = EarliestNode(node1, node2);
        System.out.println("node = " + node);
    }

    private static ListNode EarliestNode(ListNode node1, ListNode node2) {
        ListNode needNode = null;
        ListNode l1 = node1;
        while (l1 != null) {
            int val = l1.getVal();
            ListNode l2 = node2;
            while (l2 != null && l2.getVal() != val) {
                l2 = l2.next;
            }
            if (l2 != null) {
                needNode = l2;
                break;
            }
            l1 = l1.next;
        }
        return needNode;
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
