package com.github.pioneeryi;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    StringUtil util = new StringUtil();

    @Test
    public void myAtoi() {
        int res = util.myAtoi(" 001234");
        Assert.assertEquals(1234, res);
        res = util.myAtoi("-1234");
        Assert.assertEquals(-1234, res);

        res = util.myAtoi("words and 987");
        Assert.assertEquals(0, res);

        res = util.myAtoi("+-");
        Assert.assertEquals(0, res);

        res = util.myAtoi("00000-42a1234");
        Assert.assertEquals(0, res);

        res = util.myAtoi("21474836460");
        Assert.assertEquals(2147483647, res);
    }
}