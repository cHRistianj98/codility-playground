package com.christianj98.codility.prefix_sums;

public class GenomicRangeQuery {
    // A = 1
    // C = 2
    // G = 3
    // T = 4
    // S -> non-empty String of the DNA sequence
    // N = S.length
    // M = P.length or M = Q.length
    public int[] solution(String S, int[] P, int[] Q) {
        final int M = P.length;
        final int[] result = new int[M];

        for (int i = 0; i < M; i++) {
            final String dnaSequence = S.substring(P[i], Q[i] + 1);
            result[i] = findMinimalImpactFactorInDnaSequence(dnaSequence);
        }

        return result;
    }

    private int findMinimalImpactFactorInDnaSequence(String dnaSequence) {
        if (dnaSequence.contains("A")) {
            return 1;
        } else if (dnaSequence.contains("C")) {
            return 2;
        } else if (dnaSequence.contains("G")) {
            return 3;
        } else {
            return 4;
        }
    }

    public int[] gptSolution(String S, int[] P, int[] Q) {
        int N = S.length();
        int M = P.length;

        int[] A = new int[N + 1];
        int[] C = new int[N + 1];
        int[] G = new int[N + 1];
        int[] T = new int[N + 1];

        // Calculate prefix sums for each nucleotide type
        for (int i = 0; i < N; i++) {
            char nucleotide = S.charAt(i);
            A[i + 1] = A[i];
            C[i + 1] = C[i];
            G[i + 1] = G[i];
            T[i + 1] = T[i];
            switch (nucleotide) {
                case 'A':
                    A[i + 1]++;
                    break;
                case 'C':
                    C[i + 1]++;
                    break;
                case 'G':
                    G[i + 1]++;
                    break;
                case 'T':
                    T[i + 1]++;
                    break;
            }
        }

        int[] result = new int[M];

        // Process each query
        for (int k = 0; k < M; k++) {
            int start = P[k];
            int end = Q[k] + 1; // Include the end position

            // Check the minimal impact factor within the specified range
            if (A[end] - A[start] > 0) {
                result[k] = 1;
            } else if (C[end] - C[start] > 0) {
                result[k] = 2;
            } else if (G[end] - G[start] > 0) {
                result[k] = 3;
            } else {
                result[k] = 4;
            }
        }

        return result;
    }
}
