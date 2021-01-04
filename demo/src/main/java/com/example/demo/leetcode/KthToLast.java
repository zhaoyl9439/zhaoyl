package com.example.demo.leetcode;

public class KthToLast {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        ListNode head = new ListNode(1);
        int i = 1;
        ListNode p1 = head;
        while (i < arr.length) {
            p1.next = new ListNode(arr[i]);
            p1 = p1.next;
            i++;
        }
        // int last = new KthToLast().kthToLast1(head, 2);
        int left = new KthToLast().kthToLast2(head, 2);
        System.out.println(left);
    }

    //保持两个指针之间距离保持为K
    // 快慢指针
    public int kthToLast1(ListNode head, int k) {

        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        while (p!=null) {
            p = p.next;
            head = head.next;
        }
        return head.val;
    }

    public int kthToLast2(ListNode head, int k) {
        ListNode left = head, right = head;
        while (right != null) {
            right = right.next;
            if (k > 0)
                k--;
            else left = left.next;

        }
        return left.val;
    }
}
