package org.example.util;

import java.util.stream.IntStream;

public class print2DArray {
    public static String printBooleans(boolean[][] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (boolean[] x : array) {
            for (boolean y : x) {
                if (y) {
                    stringBuilder.append("X ");
                } else {
                    stringBuilder.append("O ");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
