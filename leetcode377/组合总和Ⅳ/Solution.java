package leetcode377.组合总和Ⅳ;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // 记忆化递归
    Map<Integer, Integer> map = new HashMap<>(); // key -> targrt ; value -> number of solutions

    public int combinationSum4(int[] nums, int target) {
        return backTrace(nums, target);
    }

    private int backTrace(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                res += backTrace(nums, target - nums[i]);
            }
        }
        map.put(target, res);
        return res;
    }


    // DP
    /*
     * 动态规划的做法： dp[0] = 1;
     *                 1<i<target    遍历 nums得到 nums[j]  , nums[j] <=i 时，将 dp[i] += dp[i - nums[j]]
     *                   return dp[target]
     * */
    public int combinationSum1(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

}
