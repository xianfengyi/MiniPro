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


    // 奇节点在前，偶节点在后
    public static ListNode oddEvenList(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode cur=head;
        int count=1;
        ListNode jiHead =new ListNode();
        ListNode jiCur = jiHead;
        ListNode ouHead =new ListNode();
        ListNode ouCur = ouHead;
        while(cur!=null){
            ListNode next = cur.next;
            if(count%2==1){
                jiCur.next = cur;
                jiCur = jiCur.next;
                jiCur.next=null;
            }else{
                ouCur.next = cur;
                ouCur= ouCur.next;
                ouCur.next=null;
            }
            cur.next=null;
            cur = next;
        }
        jiCur.next=ouHead.next;
        return jiHead.next;
    }


    public static void main(String[] args) {
        ListNode head = constructList(new int[]{1,2,3,4,5});
        ListNode res = oddEvenList(head);
        System.out.println(res);
    }
}