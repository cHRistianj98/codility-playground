package com.christianj98.codility.time_complexity;

import java.util.Arrays;
import java.util.List;

public class PermMissingElem {
    public static void main(String[] args) {
        int[] A = new int[]{6, 2, 1, 3, 5};
        System.out.println(solution(A));
    }

    // moje zle rozwiazanie, nie uwzglednia ostatniego elementu tablicy
    public static int solution(int[] A) {
        int currentExpectedElement = 1;
        int[] sortedArray = Arrays.stream(A)
                .sorted()
                .toArray();

        for (int element : sortedArray) {
            if (currentExpectedElement != element) {
                return currentExpectedElement;
            } else {
                currentExpectedElement++;
            }
        }
        return 0;
    }

    // rozwiazanie chata gpt z suma arytmetyczna
    public int solutionGpt(int[] A) {
        int n = A.length + 1; // Wielkość oczekiwanej tablicy, uwzględniając brakujący element
        long expectedSum = (long) (n + 1) * n / 2; // Oczekiwana suma elementów, używamy long, aby uniknąć przepełnienia
        long actualSum = 0; // Suma rzeczywistych elementów w tablicy

        for (int num : A) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum); // Oblicz brakujący element poprzez odjęcie sumy rzeczywistej od oczekiwanej
    }
}
