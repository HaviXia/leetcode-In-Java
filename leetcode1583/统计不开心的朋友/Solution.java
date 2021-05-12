package leetcode1583.统计不开心的朋友;


public class Solution {
    // 模拟
    /*
     * 进行预处理，存储每位朋友的其余 n-1 位朋友对应的亲密度下标
     * 创建 n*n 的二维数组 order, order[i][j] 代表朋友 j 在 i 的朋友列表中的亲密度 下标，遍历 preferences 填入 order 元素
     *
     * 遍历从 0 到 n−1 的每位朋友 x，进行如下操作
        找到与朋友 x 配对的朋友 y。
        找到朋友 y 在朋友 x 的朋友列表中的亲近程度下标，记为 index。
        朋友 x 的朋友列表中的下标从 0 到 index−1 的朋友都是可能的 u。遍历每个可能的 u，找到与朋友 u 配对的朋友 v。
        如果 order[u][x] < order[u][v]，则 x 是不开心的朋友。
     * */
    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        int[][] order = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                order[i][preferences[i][j]] = j;
            }
        }
        // 定义 match 找到每位朋友配对的朋友，配对情况预处理
        int[] match = new int[n];
        for (int[] pair : pairs) {
            int person0 = pair[0], person1 = pair[1];
            match[person0] = person1;
            match[person1] = person0;
        }
        int unhappyCount = 0;
        for (int x = 0; x < n; x++) {
            int y = match[x];
            int index = order[x][y];
            for (int i = 0; i < index; i++) {
                int u = preferences[x][i];
                int v = match[u];
                if (order[u][x] < order[u][v]) {
                    unhappyCount++;
                    break;
                }
            }
        }
        return unhappyCount;
    }
}

