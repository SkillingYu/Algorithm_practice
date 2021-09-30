package com.practice.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * Description leetcode 【算法 13 题  罗马数字转整数】
 * Created by SkillingYu on 2021/9/30 13:48
 */
public class Leetcode_0013 {

    public static void main(String[] args) {
        int result = romanToInt("XLIX");
        System.out.println(result);
    }

    static Map<Character,Integer> map = new HashMap<Character,Integer>(){
        {
            put('I',1);
            put('V',5);
            put('X',10);
            put('L',50);
            put('C',100);
            put('D',500);
            put('M',1000);
        }
    };

    /** 自解 */
    public static int romanToInt(String s) {
        int rec=0;
        for (int i = 0; i < s.length(); i++) {
            // 根据罗马数字的规则：
            //      I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
            //      X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
            //      C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
            // 获取当前数和后一位数进行比较，
            // 如果后一位数比前一位大，就做当前数的减法操作，否则就是加法操作
            char charAt1 = s.charAt(i);
            int parseInt1 = map.get(charAt1);
            int parseInt2=0;
            if (i<s.length()-1){
                char charAt2 = s.charAt(i+1);
                parseInt2 = map.get(charAt2);
            }
            if (parseInt2>parseInt1){
                rec-=parseInt1;
            }else{
                rec+=parseInt1;
            }
        }
        return rec;
    }


    /** leetcode 官方解题 */
    public static int romanToInt2(String s) {
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            int value = map.get(s.charAt(i));
            if (i < n - 1 && value < map.get(s.charAt(i + 1))) {
                ans -= value;
            } else {
                ans += value;
            }
        }
        return ans;
    }
}
