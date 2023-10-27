package com.github.pioneeryi;

public class Main {
    public static void main(String[] args) {
        String tar = " ";
        int ans = myAtoi(tar);

        System.out.println(ans);
    }

    public static int myAtoi(String str) {
        String afterTrim = trim(str);
        if (afterTrim.length() == 0) {
            return 0;
        }

        boolean isPositive = true;
        if (afterTrim.charAt(0) == '-') {
            isPositive = false;
        }
        String numStr = afterTrim;
        if (afterTrim.charAt(0) == '-' || afterTrim.charAt(0) == '+') {
            numStr = numStr.substring(1, afterTrim.length());
        }
        int numStartIndex = 0;
        while (numStr.charAt(numStartIndex) == '0') {
            numStartIndex++;
        }
        int numEndIndex = 0;
        while (numEndIndex < numStr.length() && Character.isDigit(numStr.charAt(numEndIndex))) {
            numEndIndex++;
        }
        String numValidStr = numStr.substring(numStartIndex, numEndIndex);
        if (numValidStr.length() == 0) {
            return 0;
        }
        long num = Long.parseLong(numValidStr);
        if (num > Integer.MAX_VALUE) {
            num = Integer.MAX_VALUE;
        }
        if (num < Integer.MIN_VALUE) {
            num = Integer.MIN_VALUE;
        }
        return isPositive ? (int) num : (int) (0 - num);
    }

    private static String trim(String s) {
        int l = 0;
        while (l<s.length() &&s.charAt(l) == ' ') {
            l++;
        }
        return s.substring(l);
    }
}

