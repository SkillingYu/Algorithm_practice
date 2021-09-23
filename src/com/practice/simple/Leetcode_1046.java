package com.practice.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Description leetcode 算法1046题 【最后一块石头的重量】
 * Created by skilling on 2021/9/18 14:00
 */
public class Leetcode_1046 {


    /**
     * 有一堆石头，每块石头的重量都是正整数。
     * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
     *     如果 x == y，那么两块石头都会被完全粉碎；
     *     如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
     * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
     * todo 最优解法 采用大根堆
     */
    public static void main(String[] args) {
        int[] ints={2,7,4,1,8,1};
        int i = lastStoneWeight(ints);
        System.out.println(i);
    }



    /** 自解，利用到了冒泡排序 */
    public static int lastStoneWeight(int[] stones) {

        while (stones.length>=2) {
            int bigOne=0;
            int bigTwo=0;
            int num=0;
            for (int i = 0; i < stones.length; i++) {
                for (int j = 0; j < stones.length-i-1; j++) {
                    if (stones[j]<stones[j+1]){
                        num=stones[j+1];
                        stones[j+1]=stones[j];
                        stones[j]=num;
                    }
                }
            }

            bigOne = stones[0];
            bigTwo = stones[1];

            if (bigOne==bigTwo){
                stones[0]=stones[stones.length-1];
                stones[1]=stones[stones.length-2];
                stones=Arrays.copyOf(stones, stones.length-2);
            }
            if (bigOne>bigTwo){
                stones[0]=bigOne-bigTwo;
                stones[1]=stones[stones.length-1];
                stones=Arrays.copyOf(stones, stones.length-1);
            }
        }
        return stones.length==1?stones[0]:0;
    }


    /** leetcode 官方解法  大根堆  */
    public static int lastStoneWeight2(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            if (a > b) {
                pq.offer(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
