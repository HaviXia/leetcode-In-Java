package leetcode35.搜索插入位置;


public class Solution {
    //二分 O(logn)
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        if (target > nums[nums.length - 1]) return nums.length;

        int left = 0;
        int right = nums.length - 1;

        if (nums[left] > target) return 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
