package com.github.pioneeryi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BT {

    List<String> res = new ArrayList();
    List<String> wordList;
    int m,n;

    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<String> findWords(char[][] board, String[] words) {
        wordList = Arrays.asList(words);
        m = board.length;
        n = board[0].length;
        backtrace(board,"",0,0);
        return res;
    }

    private void backtrace(char[][] board,String gen,int i,int j){
        if(wordList.contains(gen)){
            res.add(new String(gen));
        }

        for(int [] dir:dirs){
            int newi = i + dir[0], newj = j + dir[1];
            if(newi>=0&&newi<m&&newj>=0&&newj<n){
                backtrace(board,gen+board[newi][newj],newi,newj);
            }
        }
    }
}
