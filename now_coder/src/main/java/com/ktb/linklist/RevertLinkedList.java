package com.ktb.linklist;

public class RevertLinkedList {

    private static Node head;
    private Node last;
    private int size;

    public static void main(String[] args) {
        RevertLinkedList myLinkedList = new RevertLinkedList();
        myLinkedList.insertNode(3, 0);
        myLinkedList.insertNode(7, 1);
        myLinkedList.insertNode(9, 2);
        myLinkedList.insertNode(5, 3);
        myLinkedList.insertNode(6, 4);
        myLinkedList.getAllNodes(head);
        System.out.println();
        Node node = revert(head);
        myLinkedList.getAllNodes(node);
    }

    // 双指针反转单链表
    public static Node revert(Node head) {
        Node current = head;
        Node pre = null;
        Node temp = null;
        while (current != null) {
            temp = current.next; // current.next 临时保存
            current.next = pre;  // current.next 指向前指针
            pre = current; // 前指针 向后移动一位
            current = temp; // 后指针 向后移动一位
        }
        return pre;
    }

    public void insertNode(int value, int index) {

        Node node = new Node(value);
        if (size == 0) {
            head = node;
            last = node;
        } else if (index == 0) {
            node.next = head;
            head = node;
        } else if (index == size) {
            last.next = node;
            last = node;
        } else { // 中间插入
            Node prev = getNodeByIndex(index - 1); //获取需要插入的前一个节点
//            System.out.printf("prev===>" + prev);
            Node node_next = prev.next;
            prev.next = node;
            node.next = node_next;
        }
        size++;
    }

    private Node getNodeByIndex(int index) {
        Node current = head;
        for (int k = 0; k < index; k++) {
            current = head.next;
        }
        return current;
    }

    public void getAllNodes(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.toString());
            current = current.next;
        }
    }
}
