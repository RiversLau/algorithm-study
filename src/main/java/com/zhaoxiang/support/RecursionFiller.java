package com.zhaoxiang.support;

/**
 * Author: RiversLau
 * Date: 2017/9/27 14:19
 */
public class RecursionFiller implements ZoneFilter {

    private Zone zone;

    public void fill(Zone zone) {

        this.zone = zone;
        int size = zone.getSize();
        fill(1, size, 0, 0);
    }

    private void fill(int startNumber, int size, int startX, int startY) {

        if (size == 0) {
            return;
        } else if (size == 1) {
            zone.fill(startX, startY, startNumber);
        } else {
            for (int i = startX; i < size + startX - 1; i++) {
                zone.fill(i, startY, startNumber);
                startNumber++;
            }
            for (int i = startY; i < size + startY - 1; i++) {
                zone.fill(startX + size - 1, i, startNumber);
                startNumber++;
            }
            for (int i = startX + size - 1; i >= 1 + startX; i--) {
                zone.fill(i, startY + size - 1, startNumber);
                startNumber++;
            }
            for (int i = startY + size - 1; i >= 1 + startY; i--) {
                zone.fill(startX, i, startNumber);
                startNumber++;
            }
            fill(startNumber, size - 2, startX + 1, startY + 1);
        }
    }
}
