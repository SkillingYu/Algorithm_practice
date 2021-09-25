package com.practice.simple;

import java.util.*;

/**
 * Description leetcode 算法1002题 【查找共用字符】
 * Created by SkillingYu on 2021/9/25 13:10
 */
public class Leetcode_1002 {

    /**
     * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
     */
    public static void main(String[] args) {
        String[] strings={"bella","label","roller"};
        String[] strings2={"cool","lock","cook"};
        List<String> strings1 = commonChars(strings2);
        System.out.println(strings1);
    }

    /** 自解  执行速度慢，占用空间多 ~~~ */
    public static List<String> commonChars(String[] words) {
        List<String> list = new ArrayList<>();

        String[] s=new String[words[0].length()];
        for (int i = 0; i < words[0].length(); i++) {
            s[i]=words[0].charAt(i)+"";
            int num=0;
            for (int i1 = 1; i1 < words.length; i1++) {
                if (words[i1].contains(s[i])){
                    int indexOf = words[i1].indexOf(s[i]);
                    words[i1]=words[i1].substring(0, indexOf) + words[i1].substring(indexOf + 1);
                    num++;
                }
            }
            if (num==words.length-1){
                list.add(s[i]);
            }
        }
        return list;
    }


    /** leetcode官方解题 */
    public List<String> commonChars2(String[] words) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word : words) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                // 统计某单词中字符出现情况
                char ch = word.charAt(i);
                // 累加字符出现次数
                ++freq[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }
}
