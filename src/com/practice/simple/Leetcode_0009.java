package com.practice.simple;

/**
 * Description leetcode 【算法 9题  回文数】
 * Created by me on 2021/9/29 18:45
 */
public class Leetcode_0009 {
    public static void main(String[] args) {
        boolean palindrome = isPalindrome(-101);
        System.out.println(palindrome);
    }


    // 0 也算作是回文数
    public static boolean isPalindrome(int x) {
        boolean flag=false;
        int rec=0;
        int num = x;

        //0和尾数为0的数不是回文数
        if ((x%10==0||x<0)&&x!=0){
            return false;
        }
        while(num!=0){
            int one = num%10;
            rec= rec*10+one;
            num /= 10;
        }
        if (rec==x){
            flag=true;
        }
        return flag;
    }


    public static boolean isPalindrome2(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
