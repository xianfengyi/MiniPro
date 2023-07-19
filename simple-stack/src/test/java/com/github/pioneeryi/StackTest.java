package com.github.pioneeryi;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.Optional;

public class StackTest extends TestCase {

    public void testPush_normal() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(2, stack.getSize());
    }

    public void testPush_ExceedDefaultCapacity() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        Assert.assertEquals(5, stack.getSize());
    }

    public void testPop() {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(2);
        stack.push(3);
        Assert.assertEquals(Optional.of(3).get(), stack.pop());
        Assert.assertEquals(Optional.of(2).get(), stack.pop());
    }

    public void testEmpty() {
        Stack<Integer> stack = new Stack<Integer>();
        Assert.assertTrue(stack.empty());
        stack.push(2);
        Assert.assertFalse(stack.empty());
    }
}