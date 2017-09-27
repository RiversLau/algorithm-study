package com.zhaoxiang;

import com.zhaoxiang.support.Ant;
import com.zhaoxiang.support.Zone;

/**
 * Author: RiversLau
 * Date: 2017/9/27 15:14
 */
public class Matrix3 {

    public static void main(String[] args) {

        int size = 5;
        Zone zone = new Zone(size);

        Ant ant = new Ant();
        ant.fill(zone);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((zone.get(i, j) < 10 ? "0" + zone.get(i, j) : zone.get(i, j)) + "  ");
            }
            System.out.println();
        }
    }
}
