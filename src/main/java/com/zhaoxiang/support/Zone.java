package com.zhaoxiang.support;

/**
 * Author: RiversLau
 * Date: 2017/9/27 14:13
 */
public class Zone {

    private final int size;
    private int[][] board;

    public Zone(int size) {
        this.size = size;
        board = new int[size][size];
    }

    public int getSize() {
        return size;
    }

    public void fill(Point p, int value) {
        board[p.getX()][p.getY()] = value;
    }

    public void fill(int x, int y, int value) {
        board[x][y] = value;
    }

    public int get(Point p) {
        return board[p.getX()][p.getY()];
    }

    public int get(int x, int y) {
        return board[x][y];
    }
}
