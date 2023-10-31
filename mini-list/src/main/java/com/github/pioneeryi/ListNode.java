package com.github.pioneeryi;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode construct(int[] numbers) {
        ListNode dummyHead = new ListNode(-1);
        ListNode node = dummyHead;
        for (int num : numbers) {
            node.next = new ListNode(num);
            node = node.next;
        }
        return dummyHead.next;
    }
}
