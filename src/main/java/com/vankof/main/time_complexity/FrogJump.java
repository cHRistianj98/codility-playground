package com.vankof.main.time_complexity;

public class FrogJump {

    public static void main(String[] args) {
        System.out.println();
    }

    public int solution(int X, int Y, int D) {
        return (int )Math.ceil((double) (Y - X) / (double) D);
    }
}
