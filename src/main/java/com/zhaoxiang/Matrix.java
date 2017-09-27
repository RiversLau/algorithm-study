package com.zhaoxiang;

/**
 * Author: RiversLau
 * Date: 2017/9/27 10:13
 */
public class Matrix {

    private final static int LEFT = -1, RIGHT = 1, UP = 2, DOWN = -2;

    public static void main(String[] args) {

        int count = 6;
        int direction = DOWN;

        int[][] ary = matrixArray(count, direction);

        for (int k = 0; k < ary.length; k++) {
            for (int j = 0; j < ary[k].length; j++) {
                System.out.print(ary[k][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 获取二维数组
     * @param n
     * @param direction
     * @return
     */
    private static int[][] matrixArray(int n, int direction) {

        int ary[][] = new int[n][n];

        int i = 1;
        int row = 0, col = 0;
        while (i <= n * n) {
            switch (direction) {
                case RIGHT:
                    if (col == n || ary[row][col] > 0) {
                        row++;
                        col--;
                        direction = DOWN;
                    } else {
                        ary[row][col++] = i++;
                    }
                    break;
                case DOWN:
                    if (row == n || ary[row][col] > 0) {
                        row--;
                        col--;
                        direction = LEFT;
                    } else {
                        ary[row++][col] = i++;
                    }
                    break;
                case LEFT:
                    if (col < 0 || ary[row][col] > 0) {
                        col++;
                        row--;
                        direction = UP;
                    } else {
                        ary[row][col--] = i++;
                    }
                    break;
                case UP:
                    if (row < 0 || ary[row][col] > 0) {
                        row++;
                        col++;
                        direction = RIGHT;
                    } else {
                        ary[row--][col] = i++;
                    }
                    break;
                default:
                    break;
            }
        }

        return ary;
    }
}
