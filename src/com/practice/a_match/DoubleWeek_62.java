package com.practice.a_match;

import sun.security.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description leetcode  第 62 场双周赛
 * Created by SkillingYu on 2021/10/8
 */
public class DoubleWeek_62 {

    public static void main(String[] args) {
        //[1,1,1,1]
        //4
        //1
        // System.arraycopy(original, i * n, ints[i], 0, n);
        int[][] ints = construct2DArray(new int[]{1,1,1,1}, 4, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

        int resu=numOfPairs(new String[]{"1","1","1"},"11");
        System.out.println(resu);
    }

    /**
     * leetcode 2022题
     * 难度：简单
     * 将一维数组转变成二维数组------------------------------------------------
     * 给你一个下标从 0 开始的一维整数数组 original 和两个整数 m 和  n 。你需要使用 original 中 所有 元素创建一个 m 行 n 列的二维数组。
     * original 中下标从 0 到 n - 1 （都 包含 ）的元素构成二维数组的第一行，下标从 n 到 2 * n - 1 （都 包含 ）的元素构成二维数组的第二行，依此类推。
     * 请你根据上述过程返回一个 m x n 的二维数组。如果无法构成这样的二维数组，请你返回一个空的二维数组。
     *
     * 题目来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/convert-1d-array-into-2d-array
     */
    public static int[][] construct2DArray(int[] original, int m, int n) {
        if (m * n != original.length) {
            return new int[][]{};
        }
        // m*n-1
        int[][] ints=new int[m][n];
        int num2=0;
        for (int i = 0; i < m; i++) {
            if (n >= 0) {
                int[] in=new int[n];
                int num=0;
                for (int i1 = 0; i1 < original.length; i1++) {
                    if (num<n){
                        in[num]=original[num2];
                        num++;
                        num2++;
                    }
                }
                ints[i]=in;
            }
        }
        return ints;
    }

    /**
     * leetcode 2023题
     * 难度：中等
     * 连接后等于目标字符串的字符串对--------------------------------------------------------------------------
     * 给你一个 数字 字符串数组 nums 和一个 数字 字符串 target ，请你返回 nums[i] + nums[j] （两个字符串连接）结果等于 target 的下标 (i, j) （需满足 i != j）的数目。
     *
     * 题目来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target
     */
    public static int numOfPairs(String[] nums, String target) {
        int num=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                // i!=j 排除自己和自己进行拼接的结果
                if (target.equals(nums[i]+nums[j]) && i!=j){
                    num++;
                }
            }
        }
        return num;
    }

    /**
     * leetcode 2024题
     * 难度：中等
     * 考试的最大困扰度----------------------------------------------------------
     * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
     * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
     *     每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
     * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
     *
     * 题目来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximize-the-confusion-of-an-exam
     */
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        return 0;
    }


    /**
     * leetcode 2025题
     * 难度：困难
     * 分割数组的最多方案数------------------------------------------------------------------
     * 给你一个下标从 0 开始且长度为 n 的整数数组 nums 。分割 数组 nums 的方案数定义为符合以下两个条件的 pivot 数目：
     *     1 <= pivot < n
     *     nums[0] + nums[1] + ... + nums[pivot - 1] == nums[pivot] + nums[pivot + 1] + ... + nums[n - 1]
     * 同时给你一个整数 k 。你可以将 nums 中 一个 元素变为 k 或 不改变 数组。
     * 请你返回在 至多 改变一个元素的前提下，最多 有多少种方法 分割 nums 使得上述两个条件都满足。
     *
     * 题目来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-number-of-ways-to-partition-an-array
     */
    public static int waysToPartition(int[] nums, int k) {
        return 0;
    }


}
