package com.christianj98.codility.prefix_sums;

/**
 * A non-empty array A consisting of N integers is given. The consecutive elements of array A represent consecutive cars on a road.
 * <p></p>
 * Array A contains only 0s and/or 1s:
 * <p></p>
 * 0 represents a car traveling east,
 * 1 represents a car traveling west.
 * The goal is to count passing cars. We say that a pair of cars (P, Q), where 0 ≤ P < Q < N, is passing when P is traveling to the east and Q is traveling to the west.
 * <p></p>
 * For example, consider array A such that:
 * <p></p>
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * We have five pairs of passing cars: (0, 1), (0, 3), (0, 4), (2, 3), (2, 4).
 * <p></p>
 * Write a function:
 * <p></p>
 * class Solution { public int solution(int[] A); }
 * <p></p>
 * that, given a non-empty array A of N integers, returns the number of pairs of passing cars.
 * <p></p>
 * The function should return −1 if the number of pairs of passing cars exceeds 1,000,000,000.
 * <p></p>
 * For example, given:
 * <p></p>
 *   A[0] = 0
 *   A[1] = 1
 *   A[2] = 0
 *   A[3] = 1
 *   A[4] = 1
 * the function should return 5, as explained above.
 * <p></p>
 * Write an efficient algorithm for the following assumptions:
 * <p></p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer that can have one of the following values: 0, 1.
 */
public class PassingCars {
    public int solution(int[] A) {
        int travelEast = 0;
        int passingCars = 0;

        for (int car : A) {
            if (car == 0) {
                travelEast++;
            } else {
                passingCars += travelEast;
            }

            if (passingCars > 1_000_000_000) {
                return -1;
            }
        }

        return passingCars;
    }
}
