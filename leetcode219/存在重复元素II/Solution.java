package leetcode219.存在重复元素II;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    //暴力搜索,提交之后发现内存消耗很小，因此使用空间换时间
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j <= i + k && j < nums.length; j++) {  // j - i <= k
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //  方法2，适当的优化，   i + k, nums.length - 1 取两个的小者
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int boundary = Math.min(i + k, nums.length - 1); // 优化暴力中 j <= k + i ,使其不越界,因为要取等于，所以length - 1
            for (int j = i + 1; j <= boundary; j++) {  // j - i <= k
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    //方法3,空间换时间
    public boolean containsNearbyDuplicate2(int[] nums, int k) {

        Set<Integer> set = new HashSet<Integer>();

        if (nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i]; //防止反复取值
            if (set.contains(curr)) { //不存在
                return true;
            }
            set.add(curr);
            //需要保证 set 中，最多包含 k+1 个元素
            if (set.size() == k + 1) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    //方法4
    public boolean containsNearbyDuplicate3(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();

        if (nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            if (set.add(curr)) {
                if (set.size() == k + 1) {
                    set.remove(nums[i - k]);
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
