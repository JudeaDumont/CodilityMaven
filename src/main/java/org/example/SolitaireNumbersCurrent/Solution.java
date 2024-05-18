package org.example.SolitaireNumbersCurrent;

import java.util.Arrays;

public class Solution {
    public int solution(int[] A) {
        int numberOfLongsForBitMask = getNumberOfLongsForBitMask(A);
        long[] bitmask = getBitmask(numberOfLongsForBitMask);
        long[] innerLoops = getInnerLoops(A.length, bitmask.length);
        for(int i = 0; i < numberOfLongsForBitMask; i++){
            for(long j = 0; j < innerLoops[i]; j++){
                //so now what goes in the loop?
                //how do I only process patterns that have fewer than 6 consecutive gaps?
            }
        }

        return 0;
    }

    public long[] getInnerLoops(int arrayLength, int numOfBitMaskLongs) {
        long[] innerLoops = new long[numOfBitMaskLongs];
        for (int i = 0; i < innerLoops.length-1; i++) {//last one has only some bits set
            innerLoops[i] = Long.MAX_VALUE;
        }
        int remainder = (arrayLength % 63)-1;
        int endingBitmask = 1;
        for(int j = 0; j < remainder; j++){
            endingBitmask <<= 1;
            ++endingBitmask;
        }

        innerLoops[innerLoops.length-1] = endingBitmask;
        return innerLoops;
    }

    public long[] getBitmask(int numberOfLongsForBitMask) {
        long[] longs = new long[numberOfLongsForBitMask];
        return longs;
    }

    public int getNumberOfLongsForBitMask(int[] A) {
        return (int)Math.ceil((double) A.length / 63);
    }
}
