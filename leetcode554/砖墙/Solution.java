package leetcode554.砖墙;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    //其穿过的砖块数量加上从边缘经过的砖块数量之和是一个定值，即砖墙的高度
    //
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int res = 0;
        // 找缝隙，然后存到 map 里
        for (List<Integer> eachWall : wall) {
            int n = eachWall.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += eachWall.get(i);
                hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1); // 没有 key 返回默认值
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            res = Math.max(res, entry.getValue());
        }
        return wall.size() - res;
    }
}
