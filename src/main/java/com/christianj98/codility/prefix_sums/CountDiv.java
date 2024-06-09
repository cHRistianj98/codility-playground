package com.christianj98.codility.prefix_sums;

public class CountDiv {
//    A <= B
//    A -> <0, 2_000_000_000>
//    B -> <0, 2_000_000_000>
//    K -> <1, 2_000_000_000>
    public int solution(int A, int B, int K) {
        int counter = 0;

        for (int i = A; i <= B; i++) {
            if (i % K == 0) {
                counter++;
            }
        }
        return counter;
    }

    public int highPerformanceSolution(int A, int B, int K) {
        // number of divisors in range <1, B>
        int divisibleInRangeB = B / K;

        // if A == 0 then add 1 count
        // if A > 0 then subtract all remaining divisors
        int divisibleInRangeA = (A > 0) ? (A - 1) / K : -1;

        return divisibleInRangeB - divisibleInRangeA;
    }
}

// <0, 1> 1 -> 2
// <0, 1> 2 -> 1