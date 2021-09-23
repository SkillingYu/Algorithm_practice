package com.practice.simple;

import java.util.*;

/**
 * Description leetcode 算法496题 【下一个更大元素】 I
 * Created by SkillingYu on 2021/9/18 9:40
 */
public class Leetcode_0496 {


    /**
     * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。
     * 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。
     * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。
     * todo 最优解法 栈（单调栈）
     */
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
//        int[] nums1 = {3,1,5,7,9,2,6};
//        int[] nums2 = {1,2,3,5,6,7,9,11};
//        int[] nums1 = {1,3,5,2,4};
//        int[] nums2 = {6,5,4,3,2,1,7};

        int[] ints = nextGreaterElement3(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }


    /**（自解） */
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] nums3=new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            for (int i1 = 0; i1 < nums2.length; i1++) {
                if (nums1[i]==nums2[i1]){
                    int nu=i1;
                    while(nu < nums2.length-1){
                        nu++;
                        if (i1<nums2.length-1&&nums2[nu]>nums1[i]){
                            nums3[i]=nums2[nu];
                            break;
                        }else{
                            nums3[i]=-1;
                        }
                    }
                    if (i1>=nums2.length-1){
                        nums3[i]=-1;
                        break;
                    }
                }
            }
        }
        return nums3;
    }



    /** leetcode 官方解题1 暴力解题 */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] res = new int[len1];
        if (len1 < 1) {
            return res;
        }
        for (int i = 0; i < len1; i++) {
            int curVal = nums1[i];
            int j = 0;
            while (j < len2 && nums2[j] != curVal) {
                j++;
            }

            // 此时 nums[j] = nums[i]
            j++;
            while (j < len2 && nums2[j] < curVal) {
                j++;
            }
            if (j == len2) {
                res[i] = -1;
                continue;
            }
            res[i] = nums2[j];
        }
        return res;
    }


    /** leetcode官方解题2  栈（单调栈） 优化上面的方法，空间换时间*/
    private static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        Deque<Integer> stack = new ArrayDeque<>();
        Map<Integer, Integer> map = new HashMap<>();
        // 先处理 nums2，把对应关系存入哈希表
        for (int i = 0; i < len2; i++) {
            while (!stack.isEmpty() && stack.peekLast() < nums2[i]) {
                map.put(stack.removeLast(), nums2[i]);
            }
            stack.addLast(nums2[i]);
        }

        // 遍历 nums1 得到结果集
        int[] res = new int[len1];
        for (int i = 0; i < len1; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

}
