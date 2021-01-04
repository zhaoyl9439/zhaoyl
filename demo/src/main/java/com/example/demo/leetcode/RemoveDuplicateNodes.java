package com.example.demo.leetcode;

import java.util.HashSet;


/**
 * 移除未排序链表中的重复节点。保留最开始出现的节点。
 */
public class RemoveDuplicateNodes {

    public static void main(String[] args) {
        int arr[] = {1, 2,4, 3, 4,3, 2, 1};
        ListNode head = new ListNode(1);
        int i = 1;
        ListNode p1 = head;
        while (i < arr.length) {
            p1.next = new ListNode(arr[i]);
            p1 = p1.next;
            i++;
        }
        new RemoveDuplicateNodes().removeDuplicateNodes(head);
         ListNode p2 = head;
         while (p2 != null) {
             System.out.println(p2.val + (p2.next == null ? "" : ""));
             p2 = p2.next;
         }

    }

    public ListNode removeDuplicateNodes(ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        ListNode cur = head;
        while (cur != null && cur.next != null ) {
            set.add(cur.val);
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }        }
        return head;
    }

}
