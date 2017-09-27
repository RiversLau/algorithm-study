package com.zhaoxiang.support;

/**
 * Author: RiversLau
 * Date: 2017/9/27 14:26
 */
public class Ant implements ZoneFilter {

    private Movement[] movements;
    private int        nowMovementIndex;
    private int        footPrint;
    private Point      location;

    public Ant() {

        movements = new Movement[4];
        movements[0] = new RightMovement();
        movements[1] = new DownMovement();
        movements[2] = new LeftMovement();
        movements[3] = new UpMovement();

        nowMovementIndex = 0;
    }

    /**
     * 爬行并踩出记号
     *
     * @param zone 填充区域
     */
    public void fill(Zone zone) {
        footPrint = 1;
        location = new Point(0, 0);
        tread(zone);
        int maxPrint = zone.getSize() * zone.getSize();

        while (footPrint <= maxPrint) {
            Point nextLocation = getNextLocation();
            if (canWalkTo(zone, nextLocation)) {
                location = nextLocation;
                tread(zone);
            } else {
                changeDirection();
            }
        }
    }

    /**
     * 踩出记号
     *
     * @param zone 填充区域
     */
    private void tread(Zone zone) {
        zone.fill(location, footPrint);
        footPrint++;
    }

    /**
     * 获取下一个要爬行到的位置
     *
     * @return 下一个爬行到的位置
     */
    private Point getNextLocation() {
        Movement m = movements[nowMovementIndex];
        return m.getNextPoint(location);
    }

    /**
     * 是否可以向前爬行
     *
     * @param zone 填充区域
     * @param p 前面的位置
     * @return 如果可以向前，返回true，否则返回false
     */
    private boolean canWalkTo(Zone zone, Point p) {
        return p.getX() >= 0
                && p.getY() >= 0
                && p.getX() < zone.getSize()
                && p.getY() < zone.getSize()
                && zone.get(p) == 0;
    }

    /**
     * 换方向
     */
    private void changeDirection() {
        nowMovementIndex = (nowMovementIndex + 1) % 4;
    }

    /**
     * 爬行动作
     */
    private interface Movement {
        Point getNextPoint(Point p);
    }

    /**
     * 向上爬
     */
    private class UpMovement implements Movement {

        public Point getNextPoint(Point p) {
            return new Point(p.getX(), p.getY() - 1);
        }

    }

    /**
     * 向下爬
     */
    private class DownMovement implements Movement {

        public Point getNextPoint(Point p) {
            return new Point(p.getX(), p.getY() + 1);
        }

    }

    /**
     * 向左爬
     */
    private class LeftMovement implements Movement {

        public Point getNextPoint(Point p) {
            return new Point(p.getX() - 1, p.getY());
        }

    }

    /**
     * 向右爬
     */
    private class RightMovement implements Movement {

        public Point getNextPoint(Point p) {
            return new Point(p.getX() + 1, p.getY());
        }

    }
}
