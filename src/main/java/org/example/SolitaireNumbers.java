package org.example;

public class SolitaireNumbers {
    public static int solitaireNumbers(int[] A) {
        String bitmask = getPositiveBitMap(A);
        int allJumps = getAllJumps(bitmask, A);
        int max = allJumps;
        String inbetweenDigits = getInbetweenDigits(bitmask);
        for (long i = 0; i < Long.parseLong(inbetweenDigits, 2); ++i) {
            int thisJump = allJumps;
            String jumpPattern = "1" + getBinaryString(i, inbetweenDigits.length()) + "1";
            if (isConformentPattern(jumpPattern)) {
                for (int c = 0; c < jumpPattern.length(); c++) {
                    if (jumpPattern.charAt(c) == '0') {
                        thisJump -= A[c];
                    }
                }
                if (thisJump > max) {
                    max = thisJump;
                }
            }
        }
        return max;
    }

    public static String getBinaryString(long i, long length) {
        StringBuilder sb = new StringBuilder();
        String binaryString = Long.toBinaryString(i);
        sb.append(binaryString);
        for (long j = binaryString.length(); j < length; j++) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }

    public static boolean isConformentPattern(String jumpPattern) {
        short consecutiveZeros = 0;
        for (int i = 0; i < jumpPattern.length(); i++) {
            if (jumpPattern.charAt(i) == '0') {
                ++consecutiveZeros;
                if (consecutiveZeros == 6) {
                    return false;
                }
            } else { //it's a 1
                consecutiveZeros = 0;
            }
        }
        return true;
    }

    public static String getInbetweenDigits(String bitmask) {
        return bitmask.substring(1, bitmask.length() - 1);
    }

    public static int getAllJumps(String bitmask, int[] A) {
        int total = 0;
        for (int i = 0; i < bitmask.length(); i++) {
            if (bitmask.charAt(i) == '1') {
                total += A[i];
            }
        }
        return total;
    }

    public static String getPositiveBitMap(int[] a) {
        StringBuilder b = new StringBuilder();
        for (int i : a) {
            b.append(1);
        }
        return b.toString();
    }
}
