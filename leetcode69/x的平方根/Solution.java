package leetcode69.x的平方根;


public class Solution {
    // 二分 O(logn)
    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        if (x == 0) return 0;
        int res = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) mid * mid <= x) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }

    // 牛顿迭代 O(logn)
    int s;

    public int mySqrt1(int x) {
        s = x;
        if (x == 0) return 0;
        return ((int) (sqrts(x)));
    }

    public double sqrts(double x) {
        double res = (x + s / x) / 2;
        if (res == x) {
            return x;
        } else {
            return sqrts(res);
        }
    }
}