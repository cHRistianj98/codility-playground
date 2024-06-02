package com.christianj98.codility.counting_elements;

import java.util.Arrays;

public class PermCheck {
    public static void main(String[] args) {

    }
    public int mySolution(int[] A) {
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
            if (A[i] != i+1) {
                return 0;
            }
        }
        return 1;
    }

    public int chatGptSolution(int[] A) {
        int N = A.length;
        boolean[] seen = new boolean[N + 1];

        for (int num : A) {
            if (num < 1 || num > N) {
                return 0; // num is out of range [1..N]
            }
            if (seen[num]) {
                return 0; // num is a duplicate
            }
            seen[num] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (!seen[i]) {
                return 0; // some number in the range [1..N] is missing
            }
        }

        return 1; // All checks passed, it's a permutation
    }
}
