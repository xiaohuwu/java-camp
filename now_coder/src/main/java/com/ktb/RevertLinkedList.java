package com.ktb;

/**
 * 链表反转
 */
public class RevertLinkedList {


    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2, node);
        Node node2 = new Node(3, node1);
        Node node3 = new Node(4, node2);
        Node node4 = new Node(5, node3);
        getAllNode(node4);
        Node node5 = revertLinkList(node4);
        System.out.println();
        getAllNode(node5);
    }

    /**
     * 双指针法
     * @param head
     * @return
     */
    private  static Node revertLinkList(Node head) {
        Node prev = null;
        Node current = head;
        Node temp = null;
        while (current != null) {
            temp = current.next; //先用临时变量保存下一个节点位置
            current.next = prev; //把当前节点指向前一个节点
            prev = current; //把前一个指针往后移一位
            current = temp;//把当前指针往后移一位
        }
        return prev;
    }

    public static void getAllNode(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.toString());
            current = current.next;
        }
    }
}