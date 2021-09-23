package com.practice.simple;

import java.util.Arrays;

/**
 * Description leetcode 算法1929 数组串联
 * Created by SkillingYu on 2021/9/23 18:54
 */
public class Leetcode_1929 {


    /** 相当简单 */
    public static void main(String[] args) {
        int[] nums ={1,2,1};
        int[] concatenation = getConcatenation(nums);
        System.out.println(Arrays.toString(concatenation));
    }


    public static int[] getConcatenation(int[] nums) {
        if (nums.length>0){
            int num=1;
            int j=0;

            int[] ints = new int[nums.length * 2];
            while(num<3){
                for (int i = 0; i < nums.length; i++) {
                    ints[j]=nums[i];
                    j++;
                }
                num++;
            }
            return ints;
        }else{
            return nums;
        }
    }
}
