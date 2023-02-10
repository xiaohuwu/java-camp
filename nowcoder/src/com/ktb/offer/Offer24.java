package com.ktb.offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 * 整体思路：通过前指针、当前指针和临时指针进行位置交换，从头部开始 2 个节点为一组进行倒序交换，直到遍历到链表结尾将链表反转完成
 * <p>
 * 初始化当前指针 cur = null，前指针 pre = head
 * 当 pre != null 时，说明还未到达链表结尾，则不断进行遍历交换
 * tmp = pre.next，保存下一次要进行倒转的指针位置
 * pre.next = cur，实现链表中 2 个节点的反转
 * cur = pre，cur 指针后移一个位置
 * pre = tmp，pre 指针后移一个位置
 * 进行下一轮的倒转，直到结束时最终的链表头结点为 cur，返回 cur 即可
 */
public class Offer24 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2, node1);
        ListNode node3 = new ListNode(3, node2);
        ListNode node4 = new ListNode(4, node3);
        ListNode node5 = new ListNode(5, node4);
        ListNode node6 = new ListNode(6, node5);
        ListNode node7 = new ListNode(7, node6);
        print(node7);
        ListNode node = reverseList(node7);
        print(node);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode temp = null;
        ListNode post = head;
        while (post != null) {
            temp = post.next;
            post.next = pre;
            pre = post;
            post = temp;
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
        System.out.println();
    }


}
