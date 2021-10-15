package com.ktb;

import com.ktb.linklist.ListNode;

import javax.xml.transform.Source;
import java.util.HashSet;

//https://leetcode-cn.com/problems/linked-list-cycle/ 判断链表是否有环
public class HasCycle {

    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2, one);
        ListNode three = new ListNode(3, two);
        ListNode four = new ListNode(4, three);
        ListNode five = new ListNode(5, four);
        one.setNextNode(three);
//        printListNode(five);
        System.out.println();
        boolean b = hasCycle(five);
        System.out.println();
        System.out.println("b:" + b);
    }

    private static void printListNode(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + "->");
            current = current.next;
        }
    }

    public static boolean hasCycle(ListNode head) {
        HashSet<ListNode> hashSet = new HashSet<ListNode>();
        ListNode current = head;
        boolean flag = false;
        while (current != null) {
            System.out.print(current.val + "->");
            if (!hashSet.contains(current)) {
                hashSet.add(current);
            } else {
                System.out.println("ok============>");
                flag = true;
                break;
            }
            current = current.next;
        }
        return flag;
    }

}
