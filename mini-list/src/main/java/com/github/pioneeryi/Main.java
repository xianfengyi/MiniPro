package com.github.pioneeryi;

public class Main {

    private static ListNode constructList(int[] numbers) {
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        for (int num : numbers) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return dummyHead.next;
    }

    // 反转链表
    private static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode head = constructList(new int[]{5, 4, 3, 2, 1});
        ListNode reversed = reverseList(head);
        System.out.println(reversed);
    }
}