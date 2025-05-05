package com.github.pioneeryi;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        BT bt = new BT();
        char[][] board = new char[][]{
                {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}
        };

        String[] words = new String[]{"oath", "pea", "eat", "rain"};

        List<String> res = bt.findWords(board, words);
        System.out.println(res);
    }
}
