package com.vankof.main.time_complexity;

public class TapeEquilibruum {
    public static void main(String[] args) {

    }

    // 1. Policz sume wszystkich elementow
    // 2. Iteruj po rablicy wyznaczajac minimalna różnice dla każdego kroku
    public int solution(int[] A) {
        int sumOfTheWholeTape = 0;
        for (int element : A) {
            sumOfTheWholeTape += element;
        }

        int currentSum = 0;
        int minDifference = Integer.MAX_VALUE;
        for (int element : A) {
            currentSum += element;
            int currentDifference = Math.abs(currentSum - (sumOfTheWholeTape - currentSum));
            if (currentDifference < minDifference) {
                minDifference = currentDifference;
            }
            if (minDifference == 0) {
                return minDifference;
            }
        }
        return minDifference;
    }

    // chatGPT solution
    public int solutionG(int[] A) {
        int sumOfTheWholeTape = 0;
        for (int element : A) {
            sumOfTheWholeTape += element;
        }

        int currentSum = 0;
        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; i++) {
            currentSum += A[i];
            int currentDifference = Math.abs(2 * currentSum - sumOfTheWholeTape);
            minDifference = Math.min(minDifference, currentDifference);
        }
        return minDifference;
    }
}
