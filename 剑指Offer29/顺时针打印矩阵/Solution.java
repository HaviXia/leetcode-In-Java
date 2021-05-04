package 剑指Offer29.顺时针打印矩阵;


// 从左向右、从上向下、从右向左、从下向上
// O(mn)
public class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix[0].length == 0 || matrix.length == 0) return new int[0];

        int rows = matrix.length;
        int columns = matrix[0].length;
        int index = 0;
        int[] resOrder = new int[rows * columns];
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            // 从左到右遍历上侧元素，依次为 top, left ---> top, right
            for (int column = left; column <= right; column++) {
                resOrder[index++] = matrix[top][column];
            }
            // 从上到下遍历右侧元素，依次 top+1, right ---> bottom, right
            for (int row = top + 1; row <= bottom; row++) {
                resOrder[index++] = matrix[row][right];
            }
            // 如果 left < right && top < bottom,
            if (left < right && top < bottom) {
                // 从右到左遍历下侧元素，bottom, right - 1 ---> bottom, left + 1
                for (int column = right - 1; column > left; column--) {
                    resOrder[index++] = matrix[bottom][column];
                }
                // 从下到上遍历左侧元素， bottom, left ---> top + 1, left
                for (int row = bottom; row > top; row--) {
                    resOrder[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return resOrder;
    }
}
