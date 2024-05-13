package org.example;

public class Solution {
    public static int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        System.out.println(binaryString);
        int gap = 0;
        int potentialGap = 0;
        boolean counting = false;
        for (int sI = 0; sI < binaryString.length(); sI++) {
            if (binaryString.charAt(sI) == '1') {
                if (counting = true) {
                    if (potentialGap > gap) {
                        gap = potentialGap;
                    }
                    potentialGap = 0;
                }
                counting = true;
            } else {
                if (counting) {
                    ++potentialGap;
                }
            }
        }

        return gap;
    }
}
