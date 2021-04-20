package leetcode27.移除元素;

class Solution {
    public int removeElement(int[] nums, int val) {
        int resPoint = 0;
        for (int point = 0; point < nums.length; point++) {
            if (nums[point] != val) {
                nums[resPoint] = nums[point];
                resPoint++;
            }
        }
        return resPoint;
    }

    //优化，把right指针的值补到left位置
    //避免了需要保留的元素的重复赋值操作
    public int removeElement1(int[] nums, int val) {
        int resPoint = 0;
        int rightPoint = nums.length;
        while (resPoint < rightPoint) {
            if (nums[resPoint] == val) {
                nums[resPoint] = nums[rightPoint];
                rightPoint--;
            } else {
                resPoint++;
            }
        }
        return resPoint;
    }
}