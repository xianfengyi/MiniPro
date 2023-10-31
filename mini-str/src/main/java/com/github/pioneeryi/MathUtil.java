package com.github.pioneeryi;

import java.util.ArrayList;
import java.util.List;

public class MathUtil {

    public String multiply(String num1, String num2) {
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < num2.length(); i++) {
            String res = multi(num1, num2.charAt(i));
            String zeroStr = getZeroStr(num2.length() - i - 1);
            res += zeroStr;
            numbers.add(res);
        }

        String cur = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            String res = addNum(cur, numbers.get(i));
            cur = res;
        }
        return cur;
    }

    // 复杂数字乘单个数字
    private String multi(String numMore, char numOne) {
        int len = numMore.length();
        int index = len - 1;

        int tar = numOne - '0';
        int jinwei = 0;
        StringBuilder sb = new StringBuilder();
        while (index >= 0) {
            char c = numMore.charAt(index);
            int pro = ((c - '0') * tar + jinwei);
            sb.append(pro % 10);
            jinwei = pro / 10;
            index--;
        }
        if(jinwei!=0){
            sb.append(jinwei);
        }
        return sb.reverse().toString();
    }

    private String getZeroStr(int num) {
        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            sb.append("0");
            num--;
        }
        return sb.toString();
    }

    private String addNum(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length();
        int len2 = num2.length();
        int i = 0, j = 0;

        int jinwei = 0;
        while (i < len1 && j < len2) {
            char c1 = num1.charAt(len1 - 1 - i);
            char c2 = num2.charAt(len2 - 1 - j);
            int pro = (c1 - '0') + (c2 - '0') + jinwei;
            jinwei = pro / 10;
            sb.append(pro % 10);
            i++;
            j++;
        }
        while (i < len1) {
            char c = num1.charAt(len1 - 1 - i);
            sb.append((c - '0' + jinwei) % 10);
            jinwei = (c - '0' + jinwei) / 10;
            i++;
        }
        while (j < len2) {
            char c = num1.charAt(len2 - 1 - j);
            sb.append((c - '0' + jinwei) % 10);
            jinwei = (c - '0' + jinwei) / 10;
            j++;
        }
        if (jinwei != 0) {
            sb.append(jinwei);
        }
        return sb.reverse().toString();
    }
}
