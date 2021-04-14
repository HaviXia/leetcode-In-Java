package leetcode264.丑数II;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;


class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        //使用Set去重
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>(); //优先队列，最小堆
        set.add(1L);
        heap.offer(1L);
        int resNum = 0;
        for (int i = 0; i < n; i++) {
            Long currentNum = heap.poll();
            resNum = currentNum.intValue();
            for (int x : factors) {
                Long next = currentNum * x;
                if (set.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return resNum;
    }
}
