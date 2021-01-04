package com.example.demo.leetcode;

public class GetIntersectionNode {


    public static void main(String[] args) {
        int arr[] = {4,1,8,4,5};
        ListNode head = new ListNode(1);
        int i = 1;
        ListNode p1 = head;
        while (i < arr.length) {
            p1.next = new ListNode(arr[i]);
            p1 = p1.next;
            i++;
        }

        int arr2[] = {5,0,1,8,4,5};
        ListNode head2 = new ListNode(1);
        int i2 = 1;
        ListNode p2 = head2;
        while (i < arr2.length) {
            p2.next = new ListNode(arr2[i]);
            p2 = p2.next;
            i2++;
        }
        GetIntersectionNode node = new GetIntersectionNode();
        node.getIntersectionNode(p1, p2);
    }

    /**
     * 设链表A的长度为a，链表B的长度为b，A到相交结点的距离为c,B到相交节点的距离为d，显然可以得到两者相交链表的长度：a - c = b - d，
     * 变换一下式子得到:a + d = b + c
     * 我们用一个指针从链表A出发，到末尾后就从B出发，用另一个指针从B出发，到末尾后从A出发，由于上面的公式，
     * 当前一个指针走了a+d步数时，后一个指针走了b+c,两步数相等，即走到了相交节点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (null == headA || null == headB) return null;

        ListNode ha = headA;
        ListNode hb = headB;
        while (ha != hb) {
            ha = (null == ha ? headB : ha.next);
            hb = (null == hb ? headA : hb.next);
        }
        return ha;
    }

}
