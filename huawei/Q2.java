package huawei;

import java.util.Scanner;

/*
*  寻找重叠次数最多的区间
*   输出重叠次数最多的区间
* */
public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] recode = new int[n][3];
        int m = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            recode[i][0] = start;
            recode[i][1] = end;
            m = Math.max(m, end);
        }
        int max = 0;
        int[] temp = new int[m + 2];
        int x = recode[0][0], y = recode[0][1];
        for (int i = 0; i < n; i++) {
            for (int j = recode[i][0]; j < recode[i][1]; j++) {
                temp[j]++;
                max = Math.max(max, temp[j]);
            }
        }
        boolean flag = false;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == max && !flag) {
                x = i;
                flag = true;
            }
            if (temp[i] != max && flag) {
                y = i;
                break;
            }
        }
        System.out.printf("%d %d\n", x, y);
    }
}