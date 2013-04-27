/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bouzekri.mediacollection.tools;

import java.util.Comparator;

/**
 *
 * @author jobou
 */
public class IntComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Integer int1 = (Integer)o1;
        Integer int2 = (Integer)o2;
        return int1.compareTo(int2);
    }

    public boolean equals(Object o2) {
        return this.equals(o2);
    }
}