package com.practice.simple;

/**
 * @author huajian
 * @description leetcode 算法 2114 题
 * @date 2022/1/6 9:46
 */
public class Leetcode_2114 {

    public static void main(String[] args) {
        String[] sentences = {"please wait", "continue to fight", "continue to win"};
        int i = mostWordsFound(sentences);
        System.out.println(i);
    }


    /**
     * 题目描述：
     *  一个 句子 由一些 单词 以及它们之间的单个空格组成，句子的开头和结尾不会有多余空格。
     *  给你一个字符串数组 sentences ，其中 sentences[i] 表示单个 句子 。
     *  请你返回单个句子里 单词的最多数目 。
     *
     * @param sentences 数组
     * @return 返回结果
     */
    public static int mostWordsFound(String[] sentences) {

        int num = 0;
        for (String sentence : sentences) {
            String[] s = sentence.split(" ");
            if (num < s.length) {
                num = s.length;
            }
        }
        return num;
    }
}
