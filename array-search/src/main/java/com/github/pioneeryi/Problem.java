package com.github.pioneeryi;

import java.util.*;

public class Problem {
    public String longestPalindrome(String s) {
        int len = s.length();
        if(len==1){
            return s;
        }
        int startIndex = 0;
        int longesValue =0;
        for(int i=0;i<len;i++){
            // 以i为中心
            int res1 = getLongesPalind(s,i,i);
            if(res1>longesValue){
                longesValue = res1;
                startIndex = i-(longesValue-1)/2;
            }

            int res2 = getLongesPalind(s,i,i+1);
            if(res2>longesValue){
                longesValue = res2;
                startIndex = i+1-longesValue/2;
            }
        }
        return s.substring(startIndex,startIndex+longesValue);
    }

    private int getLongesPalind(String s,int l,int r){
        if(l<0||r>s.length()){
            return 0;
        }
        int res = 0;
        while(l>=0&&r<s.length()){
            if(s.charAt(l)!=s.charAt(r)){
                break;
            }
            res = r-l+1;
            l--;
            r++;
        }
        return res;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int [] count = new int[26];

        Map<String,List<String>> keyValues = new HashMap();

        for(String str:strs){
            String key = getKey(str);
            List<String> oneGroup =  keyValues.getOrDefault(key,new ArrayList());
            oneGroup.add(str);
            keyValues.put(key,oneGroup);
        }

        return new ArrayList<>(keyValues.values());
    }

    private String getKey(String str){
        int [] count = new int[26];
        Arrays.fill(count,0);
        for(char c:str.toCharArray()){
            int index = c-'a';
            count[index]=count[index]+1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i:count){
            sb.append(i).append("-");
        }
        return sb.toString();
    }

    List<List<String>> answers = new ArrayList();
    public List<List<String>> partition(String s) {
        backtrace(s,0,new ArrayList());
        return answers;
    }

    private void backtrace(String s,int index,List<String> ans){
        if(index==s.length()){
            answers.add(new ArrayList(ans));
            return;
        }
        for(int i=index;i<s.length();i++){
            if(isPalindromic(s,index,i)){
                ans.add(s.substring(index,i+1));
                backtrace(s,i+1,ans);
                ans.remove(ans.size()-1);
            }
        }
    }

    private boolean isPalindromic(String s ,int l, int r){
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
            l--;
            r++;
        }
        return true;
    }

    boolean ret = false;
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();

        int l=0,r=0;
        String substr="";
        while(l<len&&r<len&&l<=r){
            substr= s.substring(l,r+1);
            if(wordDict.contains(substr)){
                l=r+1;
                r=r+1;
            }else{
                r++;
            }
        }
        return wordDict.contains(substr);
    }
}
