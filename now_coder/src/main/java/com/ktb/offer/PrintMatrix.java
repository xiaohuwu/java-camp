package com.ktb.offer;
import java.util.Arrays;

//https://leetcode.cn/leetbook/read/illustrate-lcof/55v2m2/
public class PrintMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[] ints = spiralOrder(matrix);
        String s = Arrays.toString(ints);
        System.out.println("s = " + s);
    }


    public static int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int left = 0, right = matrix[0].length - 1, top = 0, bottom = matrix.length - 1, x = 0;
        int[] res = new int[(right + 1) * (bottom + 1)];
        while (true) {
            for (int column = left; column <= right; column++) {
                res[x] = matrix[top][column];
                x++;
            }
            top++;
            if (top > bottom) {
                break;
            }
            for (int row = top; row <= bottom; row++) {
                res[x] = matrix[row][right];
                x++;
            }
            right--;
            if (left > right) {
                break;
            }
            for (int column = right; column >= left; column--) {
                res[x] = matrix[bottom][column];
                x++;
            }
            bottom--;
            if (top > bottom) {
                break;
            }
            for (int row = bottom; row >= top; row--) {
                res[x] = matrix[row][left];
                x++;
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return res;
    }


}
