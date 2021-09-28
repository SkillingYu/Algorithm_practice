package com.practice.simple;

/**
 * Description leetcode 【算法：7题  整数反转】
 * Created by SkillingYu on 2021/9/28 19:04
 */
public class Leetcode_0007 {


    public static void main(String[] args) {
        int reverse = reverse(-109);
        System.out.println(reverse);


        /*double pow1 = Math.pow(-2, 31);
        double pow2 = Math.pow(2, 31);
        if (!(anInt>(int)pow1&&anInt<(int)pow2-1)){
            return 0;
        }*/
    }

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
}
