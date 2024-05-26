package com.vankof.main.time_complexity;

import java.util.Arrays;

public class MaxCounters {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(solution(5, new int[]{3, 4, 4, 6, 1, 4, 4, 4, 5, 6})));
    }

    // my solution, inefficient for big number of N+1 elements in A
    public int[] solution(int N, int[] A) {
        int currentMaxCounter = 0;
        int[] resultArray = new int[N];
        for (int i : A) {
            if (i == N + 1) {
                Arrays.fill(resultArray, currentMaxCounter);
                continue;
            }
            int counterIndex = i - 1;
            resultArray[counterIndex]++;
            if (currentMaxCounter < resultArray[counterIndex]) {
                currentMaxCounter = resultArray[counterIndex];
            }
        }
        return resultArray;
    }

    // better solution
    public int[] GptSolution(int N, int[] A) {
        int[] counters = new int[N];
        int maxCounterValue = 0;
        int base = 0;

        for (int operation : A) {
            if (operation >= 1 && operation <= N) {
                int index = operation - 1;
                counters[index] = Math.max(counters[index], base) + 1;
                maxCounterValue = Math.max(maxCounterValue, counters[index]);
            } else if (operation == N + 1) {
                base = maxCounterValue;
            }
        }

        for (int i = 0; i < N; i++) {
            counters[i] = Math.max(counters[i], base);
        }

        return counters;
    }
}
