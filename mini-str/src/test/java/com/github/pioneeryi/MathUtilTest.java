package com.github.pioneeryi;

import org.junit.Assert;
import org.junit.Test;

public class MathUtilTest {

    MathUtil util = new MathUtil();

    @Test
    public void multiply() {
        String res = util.multiply("123", "456");
        Assert.assertEquals("56088", res);

        res = util.multiply("9", "9");
        Assert.assertEquals("81", res);
    }
}