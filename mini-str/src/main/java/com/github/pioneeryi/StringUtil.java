package com.github.pioneeryi;

public class StringUtil {

    public int myAtoi(String str) {
        // 丢弃前导空格
        String trimStr = trimPrefix(str);

        // 判断正负
        boolean isPositive = isPositive(trimStr);

        // 获取有效数字部分
        String validNumber = getValidNumber(trimStr);

        // 去除前置零
        String rmPrefixZero = removePrefixZero(validNumber);

        // 类型转换为数字
        long number = castToNumber(rmPrefixZero, isPositive);

        return (int) number;
    }

    private String trimPrefix(String str) {
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(index) == ' ') {
                index++;
            }
        }
        return str.substring(index);
    }

    private boolean isPositive(String str) {
        if (str.startsWith("-")) {
            return false;
        }
        return true;
    }

    private String getValidNumber(String str) {
        if (str.length() == 0) {
            return "";
        }
        int startIndex = str.charAt(0) == '-' || str.charAt(0) == '+' ? 1 : 0;
        int endIndex = str.length();
        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isDigit(c)) {
                endIndex = i;
                break;
            }
        }
        return str.substring(startIndex, endIndex);
    }

    private String removePrefixZero(String validNumber) {
        int startIndex = 0;
        while (startIndex < validNumber.length() && validNumber.charAt(startIndex) == '0') {
            startIndex++;
        }
        return validNumber.substring(startIndex);
    }

    private long castToNumber(String validNumber, boolean isPositive) {
        if (validNumber.length() == 0) {
            return 0;
        }

        if (validNumber.length() > 11) {
            return isPositive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        long num = isPositive ? Long.parseLong(validNumber) : -1 * Long.parseLong(validNumber);
        if (num <= Integer.MIN_VALUE) {
            num = Integer.MIN_VALUE;
        } else if (num >= Integer.MAX_VALUE) {
            num = Integer.MAX_VALUE;
        }
        return num;
    }
}
