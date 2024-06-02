package com.christianj98.codility.counting_elements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingInteger {
    public static void main(String[] args) {

    }

    public int solution(int[] A) {
        Arrays.sort(A);
        int smallestMissingInteger = 1;

        for (final int element : A) {
            if (element > smallestMissingInteger) {
                if (element == smallestMissingInteger + 1) {
                    smallestMissingInteger++;
                } else {
                    return smallestMissingInteger;
                }
            }
        }
        return smallestMissingInteger > 1 ? smallestMissingInteger + 1 : smallestMissingInteger;
    }

    /*
        1. Load all data to HashSet
        2. Increment smallesMissingPositive until it's not found in HashSet
     */
    public int solutionGpt(int[] A) {
        final Set<Integer> positiveNumbers = new HashSet<>();

        for (int num : A) {
            if (num > 0) {
                positiveNumbers.add(num);
            }
        }

        int smallestMissingPositive = 1;
        while (positiveNumbers.contains(smallestMissingPositive)) {
            smallestMissingPositive++;
        }

        return smallestMissingPositive;
    }
}
