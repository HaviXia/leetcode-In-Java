package BFS迷宫;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    /*
     起点到终点的最短路径长度
     * 上、下、左、右
     * 1 将起点入队
     * 2 队首节点可扩展的点 --> 入队
     *  如果没有可扩展的点，将队首节点出队，将入队的点设置为已经访问
     * 重复该步骤，直到到达目标位置或者队列为空
     * */
    // 起始节点入队，每入队一个节点，把节点的步数标记，一个节点出队的时候需要将节点可以扩展的点出队
    // 把已经入队的节点标记好，防止重复标记节点


    public static void main(String[] args) {
        int[][] a = new int[100][100];
        int[][] v = new int[100][100];
        //四个方向
        int[] dx = {0, 1, 0, -1}; //右、下、左、上
        int[] dy = {1, 0, -1, 0};

        class point {
            int x;
            int y;
            int step;
        }

        //定义flag
        int flag = 0;
        Queue<point> queue = new LinkedList<point>();

        int n, m, startx = 0, starty = 0, p = 0, q = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                a[i][j] = sc.nextInt();
            }
            startx = sc.nextInt();
            starty = sc.nextInt();
            p = sc.nextInt();
            q = sc.nextInt();

        }
        // BFS的实现
        //1.起点入队
        point start = new point();
        start.x = startx;
        start.y = starty;
        start.step = 0;

        queue.offer(start);
        v[startx][starty] = 1; //v表示已经访问

        //队首可扩展的点入队
        while (!queue.isEmpty()) {
            //队首判断
            int x = queue.peek().x;
            int y = queue.peek().y;
            if (x == p && y == q) {
                flag = 1;
                System.out.println(queue.peek().step); //达到最终的位置
                break;
            }

            for (int k = 0; k <= 3; k++) { //三个方向的扩展
                int tempX, tempY;
                tempX = x + dx[k];
                tempY = y + dx[k];
                if (a[tempX][tempY] == 1 && v[tempX][tempY] == 0) { // 空地 & 未访问
                    point tmp = null;
                    tmp.x = tempX;
                    tmp.y = tempY;
                    tmp.step = queue.peek().step + 1;
                    queue.offer(tmp);
                    v[tempX][tempY] = 1;
                }
            }
            //队首元素出队
            queue.poll();
        }
        if (flag == 0) {
            System.out.println("没有解！");
        }
    }
}

