package leetcode1011.在D天内送达包裹的能力;


public class Solution {

    // 理解：找到船的最小的 Capacity
    /*
     *  方法1 ： 暴力做（ capacity range in ( max(weights), sum(weight in weights)) ） 船的容量在数组 「最大值 - 数组容量和」的范围内
     *  方法2 ： 二分法 bianry search，船的最小 capacity 一定是从 1 - sum(weights) 之间
     *          从 1 - sum(weights) 之间，找到一个 validWeight， 如果 validWeight 可以在 D 天之内完成任务，那么答案可能出现在 1 - validWeight 之间；
     *          如果 validWeight 不可以在 D 天之内完成任务，那么答案可能出现在 validWeight - sum(weight in weights) 之间；
     *
     * 二分法的时间复杂度  O(logN)  N = sum of weights ; 空间复杂度O(1)
     * */
    public int shipWithinDays(int[] weights, int D) {
        int sumWeight = 0;
        for (int i = 0; i < weights.length; i++) {
            sumWeight += weights[i];
        }
        // binary Search
        int left = 1;
        int right = sumWeight;

        while (left + 1 < right) { // 终止条件
            int mid = left + (right - left) / 2;
            if (ifValidWeight(weights, D, mid)) { // 如果 mid 是一个 validWeight 的话，表明答案可能出现在 1 - validWeight 之间
                right = mid;
            } else {
                left = mid;
            }
        }
        return ifValidWeight(weights, D, left) ? left : right;
    }

    // 定义 ifValidWeight 计算针对 validWeight 是否可以满足在 D 天之内完成任务
    public static boolean ifValidWeight(int[] weight, int D, int validWeight) {
        int days = 0;
        int currentWeight = 0; //记录当前船上的载重量

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] > validWeight) return false; // 一次装不下那么多，那就错了

            if (currentWeight + weight[i] > validWeight) { // 如果 currentWeight 被追加了之后，不能满足这次被运走
                days++;
                currentWeight = weight[i];
            } else {
                currentWeight += weight[i];
            }

            if (days > D) {
                return false;
            }
        }
        days++; // 最后一天
        return days <= D;
    }
}
