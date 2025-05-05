package com.github.pioneeryi;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[][] res = generateMatrix(3);
        System.out.println(res);
    }

    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = n - 1, b = 0;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            // 从左到右
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++;
            }
            // 从上到下
            t--;
            for (int i = t; i >= b; i--) {
                mat[i][r] = num++;
            }

            // 从右到左
            r--;
            for (int i = r; i >= l; i--) {
                mat[b][i] = num++;
            }

            // 从下到上
            b++;
            for (int i = b; i <= t; i++) {
                mat[l][i] = num++;
            }
            l++;
        }
        return mat;
    }
}