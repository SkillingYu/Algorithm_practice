package com.practice.simple;

import java.util.Arrays;

/**
 * @author huajian
 * @description leetcode 算法 1920 题 【基于排列构建数组】
 * @date 2022/1/6 9:58
 */
public class Leetcode_1920 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 5, 3, 4};
        int[] ints = buildArray(nums);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 题目描述：
     *  给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
     *  从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
     *
     * @param nums 整数数组
     * @return 返回结果
     */
    public static int[] buildArray(int[] nums) {
        int[] ints = new int[nums.length];

        for (int i = 0; i < ints.length; i++) {
            if (nums[i] >= nums.length || nums[i] < 0) {
                return null;
            }
            ints[i] = nums[nums[i]];
        }

        return ints;
    }
}
