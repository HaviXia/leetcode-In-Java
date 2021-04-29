package leetcode1518.换酒问题;


public class Solution {
    // numBottles 代表购入酒的数量； numExchange 代表多少个空瓶子能换一瓶酒

    // 最后返回总数 totalBottles = 初始的 numBottles 瓶酒 + 因为兑换产生的增量（在while循环中total自增的次数）
    public int numWaterBottles(int numBottles, int numExchange) {
        // 一定能喝 numBottles 瓶酒，剩下 numBottles 个空瓶，接下来拿瓶子换酒，numExchange 换 1 瓶酒

        int totalBottles = numBottles;

        while (numBottles >= numExchange) {
            numBottles = numBottles - numExchange;
            totalBottles++;
            numBottles++;
        }
        return totalBottles;
    }

    // leetcode官方 O(1)解
    public int numWaterBottles1(int numBottles, int numExchange) {
        return numBottles >= numExchange ? (numBottles - numExchange) / (numExchange - 1) + 1 + numBottles : numBottles;
    }
}