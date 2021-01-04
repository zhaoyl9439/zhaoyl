package com.example.demo.leetcode;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;
import java.util.concurrent.Callable;

public class Leetcode {


    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     */
    private static int[] nums = {2, 11, 7, 15};
    private static int target = 9;
    // 时间复杂度为O(n^2）
    private static int[] twoSum1(int[] nums, int target){
        for (int i = 0; i < Leetcode.nums.length; i++) {
            for (int j = i+1; j < Leetcode.nums.length; j++) {
                if (Leetcode.nums[i] == Leetcode.target - Leetcode.nums[j]) {
                    return new int[] { i, j };
                }
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
    // 时间复杂度O(n)
    private static int[] twoSum2(int[] nums,int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])){
                return new int[]{map.get(target-nums[i]) , i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("no two sum solution");
    }


    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头
     * @return
     */

    public class ListNode {
        int val;  // 值
        ListNode next; // 下一个节点的地址
        ListNode(int x) { val = x; }  // 赋值
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;

        while (l1 != null || l2 != null){
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1){
            cur.next = new ListNode(carry);
        }

        return pre.next;
    }


    public static void main(String[] args) {
       // System.out.println(JSONObject.toJSONString(twoSum2(nums, target)));
    }
}
