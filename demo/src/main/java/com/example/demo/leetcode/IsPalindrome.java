package com.example.demo.leetcode;

public class IsPalindrome {


    public static void main(String[] args) {
        //int arr[] = {1, 2, 3, 4, 4, 3, 2, 1};
        int arr[] = {1, 2, 2};
        ListNode head = new ListNode(1);
        int i = 1;
        ListNode p1 = head;
        while (i < arr.length) {
            p1.next = new ListNode(arr[i]);
            p1 = p1.next;
            i++;
        }
        IsPalindrome isPalindrome = new IsPalindrome();
        // isPalindrome.findMidNode(head); //找链表中间值
        isPalindrome.reverseLinked2(head); //链表反转
        //boolean palindrome = isPalindrome.isPalindrome(head);
        //System.out.println(palindrome);


    }

    public boolean isPalindrome(ListNode head) {
        if(null == head) return true;

        ListNode midNode = findMidNode(head);
        ListNode reverseLinked = reverseLinked(midNode.next);

        ListNode fis = head;
        ListNode sec = reverseLinked;
        while ( null != sec) {
            if (fis.val != sec.val) return false;
            fis = fis.next;
            sec = sec.next;
        }
        return true;
    }

    /**
     * 找中间节点 快慢指针
     * @param head
     * @return
     */
    public ListNode findMidNode(ListNode head) {

        ListNode fast = head;
        ListNode low = head;
        while (null != fast.next && null != fast.next.next) {
            fast = fast.next.next;
            low = low.next;
        }
        return low;
    }

    /**
     * 链表反转
     *  1.头结点插入
     *    1.创建一个带头节点的链表resultList
     *    2.定义一个循环链表变量prev，prev的初始值为待反转的链表
     *    3.遍历待反转的链表，遍历条件为 (prev !=null)
     *       3.1 定义一个临时链表变量tempList保存prev->next的值（因为prev->next值会改变），用于下一次循环。
     *       3.2 把prev当前指向的首节点和resultList链表的头节点之后的节点拼接起来。
     *       3.3 把3.2步骤中拼接的节点 再拼接到resultList头节点后。
     *       3.4 prev重新赋值为3.1步骤中保存的tempList的值。
     *       返回resultList->next.即反转后的链表。
     *  2. 就地反转
     *
     * @param node
     * @return
     */
    public ListNode reverseLinked(ListNode node) {

        ListNode resultList = new ListNode(-1); //新建链表，接收反转后的链表
        ListNode prev = node;
        ListNode tempList;
        while (null != prev) {
            tempList = prev.next; //暂存下一节点
            prev.next = resultList.next; //当前节点指向新链表的头结点的下一节点
            resultList.next = prev; //当前节点赋给新节点的头结点的下一节点
            prev = tempList; //从下一节点开始循环

        }
        return resultList.next;
    }

    public ListNode reverseLinked2(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode cur = head.next;
        head.next = null; //使输入的表头反转后指向null
        ListNode pre = head;
        ListNode temp;
        while (cur != null){
            temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}
