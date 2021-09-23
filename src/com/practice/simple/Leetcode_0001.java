package com.practice.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description leetcode 算法 1  两数之和
 * Created by SkillingYu on 2021/9/23 19:12
 */
public class Leetcode_0001 {


    /**
     * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
     */
    public static void main(String[] args) {
        int[] nums ={2,11,7,15};
        int target = 9;

        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));


    }


    /** 自解 */
    public static int[] twoSum(int[] nums, int target) {

        int[] ints=new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = 0; i1 < nums.length; i1++) {
                if (nums[i]+nums[i1]==target && i!=i1){
                    ints[0]=i;
                    ints[1]=i1;
                    return ints;
                }
            }
        }
        return ints;
    }

    /** 自解 优化 （考虑到用hash表实现优化，空间换时间）*/
    public static int[] twoSum2(int[] nums, int target) {
        int[] ints=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(target-nums[i],i);
        }
        for (int i1 = 0; i1 < nums.length; i1++) {
            if (map.keySet().contains(nums[i1])){
                Integer integer = map.get(nums[i1]);
                if (integer!=i1){
                    ints[0]=integer;
                    ints[1]=i1;
                    break;
                }
            }
        }
        return ints;
    }


    /** 官方hash表优化解法  */
    public int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (hashtable.containsKey(target - nums[i])) {
                return new int[]{hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }
}
