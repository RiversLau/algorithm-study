package com.zhaoxiang;

import com.zhaoxiang.support.RecursionFiller;
import com.zhaoxiang.support.Zone;

/**
 * Author: RiversLau
 * Date: 2017/9/27 14:13
 */
public class Matrix2 {

    public static void main(String[] args) {

        int size = 7;
        Zone zone = new Zone(size);

        RecursionFiller filler = new RecursionFiller();
        filler.fill(zone);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print((zone.get(i, j) < 10 ? "0" + zone.get(i, j) : zone.get(i, j)) + "  ");
            }
            System.out.println();
        }
    }
}
