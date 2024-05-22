package org.example.current;

public class Solution {
    //  v                       v  v
    // [1, -2, -2, -2, -2, -2, -2, 1] = 0

    //  v                      v
    // [1, -2, -2, -2, -2, -2, 1] = 2

    //  v   v                      v
    // [1, -1, -2, -3, -4, -5, -6, 1] = 1

    //  v       v                       v   v                       v   v                       v
    // [1, -1, -2, -3, -4, -5, -6, -7, -1, -2, -3, -4, -5 ,-6, -7, -1, -2, -3, -4 , -5, -6, -7, 1]

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

    public void getNegativeRun(int[] a, int currentRunTotal, boolean[] visited) {
        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {

            }
        }

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
