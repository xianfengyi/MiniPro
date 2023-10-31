package com.github.pioneeryi;

import java.util.ArrayList;
import java.util.List;

public class Reverse {

    public ListNode reverseKGroup(ListNode head, int k) {
        // 先把原来的按K个分成多组
        List<ListNode> nodeHeads = new ArrayList();
        ListNode cur = head;
        int count=0;
        ListNode oneHead = cur;
        while(cur!=null){
            count++;
            if(count%k==0){
                nodeHeads.add(oneHead);
                ListNode next = cur.next;
                cur.next=null;
                cur =next;
            }else{
                cur = cur.next;
            }
        }

        // 逐个翻转
        for(int i=0;i<nodeHeads.size();i++){
            ListNode reversed = reverse(nodeHeads.get(i));
            nodeHeads.set(i,reversed);
        }

        // 如果 count 不是 k的整数倍，那么还需要加上最后一段
        ListNode lastSeg = nodeHeads.get(nodeHeads.size()-1);
        ListNode lastNode = getLast(lastSeg);
        lastNode.next = oneHead;

        // 再串起来
        for(int i=0;i<nodeHeads.size();i++){
            ListNode last = getLast(nodeHeads.get(i));
            if(i<nodeHeads.size()-1){
                last.next = nodeHeads.get(i+1);
            }
        }

        return nodeHeads.get(0);
    }

    private ListNode reverse(ListNode head){
        if(head==null){
            return head;
        }
        ListNode pre = null;
        while(head!=null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    private ListNode getLast(ListNode head){
        while(head.next!=null){
            head = head.next;
        }
        return head;
    }

}
