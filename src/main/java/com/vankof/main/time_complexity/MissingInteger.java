package com.vankof.main.time_complexity;

import java.util.Arrays;

public class MissingInteger {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int smallestMissingInteger = 1;

        for (final int i : A) {
            if (i > smallestMissingInteger) {
                if (i == smallestMissingInteger + 1) {
                    smallestMissingInteger++;
                } else {
                    return smallestMissingInteger;
                }
            }
        }
        return smallestMissingInteger > 1 ? smallestMissingInteger + 1 : smallestMissingInteger;
    }
}
