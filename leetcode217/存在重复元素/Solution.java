package leetcode217.存在重复元素;


import java.util.HashSet;
import java.util.Set;

class Solution {
    /*public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }*/

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) { // 发现set不能插入（包含相同的元素）
                return true;
            }
        }
        return false;
    }
}