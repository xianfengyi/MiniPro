package com.github.pioneeryi;

import org.junit.Test;

public class ReverseTest {

    @Test
    public void reverseKGroup() {
        ListNode head = ListNode.construct(new int[]{1, 2, 3, 4, 5});

        Reverse reverse = new Reverse();
        ListNode res = reverse.reverseKGroup(head, 2);
        System.out.println(res);
    }
}