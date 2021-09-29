package com.practice.simple;

/**
 * Description leetcode 【算法：7题  整数反转】
 * Created by SkillingYu on 2021/9/28 19:04
 */
public class Leetcode_0007 {

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     */
    public static void main(String[] args) {
        int reverse = reverse2(-109999999);
        System.out.println(reverse);
    }

    /** 自解 */
    public static int reverse(int x) {
        String s = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        //负数处理
        if (x<0){
            s=s.substring(1);
            sb.append("-");
        }
        for (int i = 0; i < s.length(); i++) {
            if (x<0){
                //去掉负号，上面已经追加了负号
                x=Integer.parseInt(s.substring(1));
            }
            if (x%10==0 && x!=0){
                // 此层判断是 解决数字中间有零的情况 和 最后一位有0的情况而出现的问题（例如 109 120）
                if (i==0){
                    sb.append(x%10==0?"":x%10);
                }else{
                    sb.append(x%10);
                }
            }else{
                sb.append(x%10==0?x:x%10);
            }
            if (i!=s.length()-1){
                if (x<0){
                    //去掉负号
                    x=Integer.parseInt(s.substring(1,s.length()-i-1));
                }else{
                    x=Integer.parseInt(s.substring(0,s.length()-i-1));
                }
            }
        }
        try {
            return Integer.parseInt(sb.toString());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /** 最优解法 */
    public static int reverse2(int x) {
        int rev = 0;
        while (x != 0) {
            if (rev < Integer.MIN_VALUE / 10 || rev > Integer.MAX_VALUE / 10) {
                return 0;
            }
            //取出x的末尾数字
            int digit = x % 10;
            x /= 10;
            // 将取出的数字推入rev末尾
            rev = rev * 10 + digit;
        }
        return rev;
    }
}
