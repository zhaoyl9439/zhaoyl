package com.example.demo.leetcode;

public class DeleteNode {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        ListNode head = new ListNode(1);
        int i = 1;
        ListNode p1 = head;
        while (i < arr.length) {
            p1.next = new ListNode(arr[i]);
            p1 = p1.next;
            i++;
        }
        ListNode p2 = head.next.next;
        new DeleteNode().deleteNode(p2);
        ListNode p3 = head;
        while (p3 != null) {
            System.out.println(p3.val + (p3.next == null ? "" : ""));
            p3 = p3.next;
        }


    }

    //删除单向链表中间的某个节点（即不是第一个或最后一个节点）
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
