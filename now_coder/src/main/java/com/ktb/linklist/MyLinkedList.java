package com.ktb.linklist;

public class MyLinkedList {

    private Node head;
    private Node last;
    private int size;

    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.insertNode(3, 0);
        myLinkedList.insertNode(7, 1);
        myLinkedList.insertNode(9, 2);
        myLinkedList.insertNode(5, 3);
        myLinkedList.insertNode(6, 4);
        myLinkedList.getAllNodes();
        System.out.println();
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

    /**
     * this is so bad 没考虑到链表头部和尾部
     *
     * @param index
     * @return
     */
//    public void deleteNode(int index){
//        Node prev = getNodeByIndex(index - 1);
//        prev.next = prev.next.next;
//    }
    public Node deleteNode(int index) {
        Node removedNode = null;
        if (index == 0) {
            removedNode = head.next;
            head.next = head.next.next;
        } else if (index == size - 1) {
            Node prev = getNodeByIndex(index - 1);
            removedNode = prev.next;
            prev.next = null;
            last = prev;
        } else { // 中间插入
            Node prev = getNodeByIndex(index - 1);
            removedNode = prev.next;
            prev.next = prev.next.next;
        }
        return removedNode;
    }


    private Node getNodeByIndex(int index) {
        Node current = head;
        for (int k = 0; k < index; k++) {
            current = head.next;
        }
        return current;
    }

    public void getAllNodes() {
        Node current = head;

        while (current != null) {
            System.out.print(current.toString());
            current = current.next;
        }
    }
}

