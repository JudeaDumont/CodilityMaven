package org.example.current;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class Solution {
    //  v                       v  v
    // [1, -2, -2, -2, -2, -2, -2, 1] = 0

    //  v                      v
    // [1, -2, -2, -2, -2, -2, 1] = 2

    //  v   v                      v
    // [1, -1, -2, -3, -4, -5, -6, 1] = 1

    //  v       v                       v   v                       v   v                       v
    // [1, -1, -2, -3, -4, -5, -6, -7, -1, -2, -3, -4, -5 ,-6, -7, -1, -2, -3, -4 , -5, -6, -7, 1]

    //  v                   v                            v                           v  v
    // [1, -1, -1, -1, -1, -1, -7, -10, -10, -10, -10, -21, -21, -21, -21, -21, -1, -1, 1]

    //  v                   v                      v                             v      v
    // [1, -1, -1, -1, -1, -1, -7, -10, -10, -10, -10, -21, -21, -21, -21, -21, -1, -1, 1]

    //  v                       v                       v                             v      v
    // [1, -1, -1, -1, -1, -1, -7, -10, -10, -10, -10, -20, -21, -21, -21, -21, -21, -1, -1, 1] = 26
    //size = 20, v = 5

    //  v               v           v               v                      v
    // [1, -3, -9, -8, -3, -7, -6, -3, -5, -4, -3, -2, -3, -2, -7, -8, -6, 1] = -5
    //size = 18, v = 5

    // v                   v                  v             v                  v            v
    // [1, -90, -90, -90, -3, -90, -90, -90, -3, -90, -90, -3, -90, -90, -90, -3, -90, -90, 1]
    //size = 19, v = 6


    // Starting position where there is a pointer every 7 elements:
    //  v                           v                                  v                     v
    // [1, -1, -1, -1, -1, -1, -7, -10, -10, -10, -10, -20, -21, -21, -21, -21, -21, -1, -1, 1] = -28
    //size = 20, v = 5

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return A[0];
        }
        int currentRunTotal = getFirstAndLastElementSum(A);
        if (A.length == 2) {
            return currentRunTotal;
        }
        boolean[] visited = new boolean[A.length];
        visited[0] = true;
        visited[A.length - 1] = true;
        currentRunTotal = getPositiveRun(A, currentRunTotal, visited);

        if (!needsNegativeRun(visited)) {
            return currentRunTotal;
        }

        getNegativeRun(A, currentRunTotal, visited);

        return 0;
    }

    public boolean needsNegativeRun(boolean[] visited) {
        int negativeGaps = 0;
        for (boolean b : visited) {
            if (!b) {
                if (++negativeGaps == 6) {
                    return true;
                }
            } else {
                negativeGaps = 0;
            }
        }
        return false;
    }
    public Integer getNegativeRun(int[] a, int currentRunTotal, boolean[] visited) {

        int start = 0;
        int end = 0;
        boolean negativeStreak = false;

        for (int i = 0; i < visited.length; i++) {
            boolean b = visited[i];
            if (!b) {
                if (negativeStreak) {
                    ++end;
                } else {
                    negativeStreak = true;
                    start = i;
                    end = i;
                }
            } else {
                if (negativeStreak) {
                    if (end - start > 5) {
                        currentRunTotal += processGap(Arrays.copyOfRange(a, start, end));
                    }
                }
                start = 0;
                end = 0;
                negativeStreak = false;
            }
        }
        return 0;
    }


    // I think this is it.
    //  v   v                       v    v                             v                     v
    //  v       v                   v         v                        v                     v
    //  v           v               v              v                   v                     v
    //  v               v           v                   v              v                     v
    //  v                   v       v                        v         v                     v
    //  v                       v   v                             v                          v
    //  v       v                        v    v                             v                v
    //  v           v                    v         v                        v                v
    //  v               v                v              v                   v                v
    //  v                   v            v                   v              v                v
    //  v                       v        v                        v                          v
    //  v                       v        v                             v                     v
    //  v           v                         v    v                             v           v
    //  v               v                     v         v                        v           v
    //  v                   v                 v              v                   v           v
    //  v                       v             v                   v                          v
    //  v                       v             v                        v                     v
    //  v                       v             v                             v                v
    //  v               v                          v    v                             v      v
    //  v                   v                      v         v                        v      v
    //  v                       v                  v              v                          v
    //  v                       v                  v                   v                     v
    //  v                       v                  v                        v                v
    //  v                       v                  v                             v           v
    //  v                  v                            v    v                            v  v
    //  v                       v                       v         v                          v
    //  v                       v                       v              v                     v
    //  v                       v                       v                   v                v
    //  v                       v                       v                        v           v
    //  v                       v                       v                             v      v
    // [1, -1, -1, -1, -1, -1, -7, -10, -10, -10, -10, -20, -21, -21, -21, -21, -21, -1, -1, 1]
    private int processGap(int[] ints) {
        if(ints.length == 6){
            int max = ints[0];
            for (int i = 1; i < ints.length; i++) {
                if(ints[i] > max){
                    max = ints[i];
                }
            }
            return max;
        }
        return 0;
    }

    public Integer getPositiveRun(int[] A, Integer currentRunTotal, boolean[] visited) {
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] >= 0) {
                visited[i] = true;
                currentRunTotal += A[i];
            }
        }
        return currentRunTotal;
    }

    private static int getFirstAndLastElementSum(int[] A) {
        return A[0] + A[A.length - 1];
    }
}
