package com.practice.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description leetcode 【算法 14题  最长公共前缀】
 * Created by SkillingYu on 2021/9/30 15:09
 */
public class Leetcode_0014 {

    public static void main(String[] args) {
        String[] strings={"dog","racecar","car"};
        String[] strings3={"cir","car"};
        String[] strings2={"flower","flow","flight"};
        String s = longestCommonPrefix(strings3);
        System.out.println(s);
    }

    /** 自解 */
    public static String longestCommonPrefix(String[] strs) {
        Map<Integer, Character> map = new HashMap<>();
        if (strs.length==1){
            return strs[0];
        }
        int num=0;
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int count=0;
            for (int i1 = 0; i1 < str.length(); i1++) {
                if (i==0){
                    map.put(i1,str.charAt(i1));
                }else{
                    if (i1 < strs[0].length()){
                        Character character = map.get(i1);
                        if (character==str.charAt(i1)){
                            count++;
                        }else{
                            break;
                        }
                    }
                }
            }
            if (i==1||count<num){
                num=count;
            }
        }
        if (num>0){
            return strs[0].substring(0,num);
        }
        return "";
    }


    /** leetcode官方解题方法1  横向扫描  */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }
        return str1.substring(0, index);
    }

}
