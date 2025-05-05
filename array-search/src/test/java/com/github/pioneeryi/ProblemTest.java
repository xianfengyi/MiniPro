package com.github.pioneeryi;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ProblemTest {

    @Test
    public void longestPalindrome() {
        Problem problem = new Problem();
        String result = problem.longestPalindrome("babad");
        Assert.assertEquals("bab",result);
        result = problem.longestPalindrome("cbbd");
        Assert.assertEquals("bb",result);
    }

    @Test
    public void testGroupAnagrams(){
        Problem problem = new Problem();
        List<List<String>> ret=  problem.groupAnagrams(new String[]{"bdddddddddd","bbbbbbbbbbc"});
        System.out.println(ret.toString());
    }

    @Test
    public void partition() {
        Problem problem = new Problem();
        List<List<String>> res=problem.partition("aab");
        System.out.println(res.toString());
    }

    @Test
    public void wordBreak() {
        Problem problem = new Problem();
        List<String> wordDict = Arrays.asList(new String[]{"aaaa","aaa"});
        boolean ret = problem.wordBreak("aaaaaaa",wordDict);
        Assert.assertTrue(ret);
    }
}