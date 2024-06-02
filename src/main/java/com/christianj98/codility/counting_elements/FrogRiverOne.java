package com.christianj98.codility.counting_elements;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {

    }
    public int solution(int X, int[] A) {
        Set<Integer> positionsCovered = new HashSet<>();
        for (int time = 0; time < A.length; time++) {
            positionsCovered.add(A[time]);
            if (positionsCovered.size() == X) {
                return time;
            }
        }

        return -1;
    }
}
