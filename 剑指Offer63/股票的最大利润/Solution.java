package 剑指Offer63.股票的最大利润;

/**
 * @author ：hkxia
 * @description：TODO
 * @date ：2021/4/25 22:50
 */
public class Solution {

    // 暴力方法，双层循环，时间复杂度 O(n^2)
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    // dp 状态转移方程为 dp[i] 代表以 price[i] 为结尾的子数组的最大利润

    //因此前 ii 日最大利润 dp[i] 等于前 i - 1 日最大利润 dp[i-1] 和第 i 日卖出的最大利润中的最大值
    // 状态转移方程 dp[i] = max{ dp[i-1], price[i] - min{price[0 : i]}}  dp[0] = 0
    // 时间复杂度O(n)

    public int maxProfit1(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for (int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }
}
