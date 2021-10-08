package com.practice.simple;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Description leetcode  【算法 20题 有效的括号】
 * Created by SkillingYu on 2021/10/8 10:20
 */
public class Leetcode_0020 {

    /**
     *
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     *
     */
    public static void main(String[] args) {
        // "{[]}"  "([)]()"  "()"
        String s="([)]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }


    /**
     * 根据leetcode官方思路解题
     *
     * 通过 栈 解题
     */
    public static boolean isValid(String s) {
        if (s.length()%2==1){
            return false;
        }

        Map<String,String> map= new HashMap<>();
        map.put(")","(");
        map.put("]","[");
        map.put("}","{");

        Deque<String> deque = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            String ch = String.valueOf(s.charAt(i));
            if (map.containsKey(ch)) {
                // deque.peek() 取出栈顶元素
                if (deque.isEmpty() || !deque.peek().equals(map.get(ch))) {
                    return false;
                }
                //弹出栈顶元素
                deque.pop();
            } else {
                deque.push(ch);
            }
        }
        return deque.isEmpty();
    }

}
