package leetcode122.买卖股票的最佳时机II;

/**
 * @author ：hkxia
 * @description：TODO
 * @date ：2021/5/14 14:14
 */
public class Solution {

    // 贪心
    /*
     * 因为知道每一天的价格，只要后一天的价格比前一天高，那么就在前一天 买进，后一天 卖出
     *   时间复杂度 O(n)
     * */
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        return ans;
    }


    // 动态规划
    /*
     * 把 每一天之前的状态 都记录，针对每一天对应一个状态；这个状态表示 当前你 0股对应的利润、1股对应的利润
     *  每一天和前一天进行对比，当前需要 卖出还是买进
     *   时间复杂度 O(n)
     * */
    public int maxProfit1(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
