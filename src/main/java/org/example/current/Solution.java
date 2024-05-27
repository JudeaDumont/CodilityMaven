package org.example.current;

import java.util.Arrays;

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

        currentRunTotal += getNegativeRun(A, visited);

        return currentRunTotal;
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

    public Integer getNegativeRun(int[] a, boolean[] visited) {

        int start = 0;
        int end = 0;
        boolean negativeStreak = false;

        int negativeRunTotal = 0;

        for (int i = 0; i < visited.length; i++) {
            boolean b = visited[i];
            if (!b) {
                if (negativeStreak) {
                    ++end;
                } else {
                    negativeStreak = true;
                    start = i;
                    end = i + 1;
                }
            } else {
                if (negativeStreak) {
                    if (end - start > 5) {
                        negativeRunTotal += processGap(Arrays.copyOfRange(a, start, end));
                    }
                }
                start = 0;
                end = 0;
                negativeStreak = false;
            }
        }
        return negativeRunTotal;
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

    //  v                       v                            v    v                          v
    //  v                       v                            v         v                     v
    //  v                       v                            v              v                v
    //  v                       v                            v                   v           v
    //  v                       v                            v                        v      v
    //  v                       v                            v                            v  v
    // [1, -1, -1, -1, -1, -1, -7, -10, -10, -10, -10, -20, -21, -21, -21, -21, -21, -1, -1, 1]
    private int processGap(int[] ints) {
        if (ints.length == 6) {
            return getMaxFrom6(ints);
        } else if (ints.length == 7) {
            return getMaxFrom7(ints);
        } else if (ints.length > 7) {
            return getMaxFromEight(ints);
        }
        return 0;
    }

    //  v                             v
    //       v                        v
    //            v
    //                 v
    //                      v
    //                           v
    //       v                            v
    //[-13, -10, -21, -21, -21, -21, -8, -1]

    //   v                       v   v                       v   v                       v   v                       v   v                       v   v                       v
    //       v                   v       v                   v       v                   v       v                   v       v                   v       v
    //           v               v           v               v           v               v           v               v           v               v           v
    //               v           v               v           v               v           v               v           v               v           v               v
    //                   v       v                   v       v                   v       v                   v       v                   v       v                   v
    //                       v   v                       v   v                       v   v                       v   v                       v   v                       v

    //       v                       v   v                       v   v                       v   v                       v   v                       v   v
    //           v                   v       v                   v       v                   v       v                   v       v                   v       v
    //               v               v           v               v           v               v           v               v           v               v           v
    //                   v           v               v           v               v           v               v           v               v           v               v
    //                       v       v                   v       v                   v       v                   v       v                   v       v                   v
    //                       v       v                       v   v                       v   v                       v   v                       v   v                       v

    //           v                       v   v                       v   v                       v   v                       v   v                       v
    //               v                   v       v                   v       v                   v       v                   v       v                   v
    //                   v               v           v               v           v               v           v               v           v               v
    //                       v           v               v           v               v           v               v           v               v           v
    //                       v           v                   v       v                   v       v                   v       v                   v       v
    //                       v           v                       v   v                       v   v                       v   v                       v   v

    //               v                       v   v                       v   v                       v   v                       v   v                       v
    //                   v                   v       v                   v       v                   v       v                   v       v                   v
    //                       v               v           v               v           v               v           v               v           v               v
    //                       v               v               v           v               v           v               v           v               v           v
    //                       v               v                   v       v                   v       v                   v       v                   v       v
    //                       v               v                       v   v                       v   v                       v   v                       v

    //                   v                       v   v                       v   v                       v   v                       v   v                       v
    //                       v                   v       v                   v       v                   v       v                   v       v                   v
    //                       v                   v           v               v           v               v           v               v           v               v
    //                       v                   v               v           v               v           v               v           v               v           v
    //                       v                   v                   v       v                   v       v                   v       v                   v
    //                       v                   v                       v   v                       v   v                       v   v                       v

    //                       v                       v   v                       v   v                       v   v                       v   v                       v
    //                       v                       v       v                   v       v                   v       v                   v       v                   v
    //                       v                       v           v               v           v               v           v               v           v               v
    //                       v                       v               v           v               v           v               v           v               v           v
    //                       v                       v                   v       v                   v       v                   v       v                   v
    //                       v                       v                       v   v                       v   v                       v   v                       v
    // [-1, -1, -1, -1, -1, -1, -7, -1, -1, -1, -1, -2, -2, -2, -2, -2, -2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1]
    private int getMaxFromEight(int[] ints) {

        int[] stationaryPositions = getStationaryPointerPositions(ints.length);
        int[] inbetweenPositions = getInbetweenPointerPositions(stationaryPositions);

        int max = Integer.MIN_VALUE;
        int startPosition = 0;
        int expandingSection = 0;
        while (stationaryPositions[stationaryPositions.length - 1] < ints.length + 1) {
            int currentSum = 0;

            String string = createReadableString(stationaryPositions, inbetweenPositions, ints.length);
            for (int i = 0; i < inbetweenPositions.length; i++) {
                currentSum += ints[inbetweenPositions[i]];
                if (inbetweenPositions[i] + 6 >= ints.length) {
                    //hop out
                    i = inbetweenPositions.length;
                } else {
                    currentSum += ints[stationaryPositions[i]];
                    if (stationaryPositions[i] + 6 >= ints.length) {
                        //hop out
                        i = inbetweenPositions.length;
                    }
                }
            }
            if (currentSum > max) {
                max = currentSum;
            }

            //iteration logic // it's more like one section expands while the others are pushed right // and once a section is expanded, the next one is expanded

            //increment each inbetween position
            //if the first position is 6, that means we set it to +1 of whatever the old start position was.
            if (inbetweenPositions[expandingSection] == ((expandingSection + 1) * 6) - 1 &&
                    stationaryPositions[expandingSection] == ((expandingSection + 1) * 6) + 5) {
                //section is complete
                ++expandingSection;
            } else if (inbetweenPositions[expandingSection] == ((expandingSection + 1) * 6) - 1) {
                //expand
                for (int i = expandingSection; i < stationaryPositions.length; i++) {
                    ++stationaryPositions[i];
                }

                ++startPosition;

                //reset inbetween
                for (int i = expandingSection; i < inbetweenPositions.length; i++) {
                    inbetweenPositions[i] = (i * 7) + startPosition;
                }
            } else {
                for (int i = expandingSection; i < inbetweenPositions.length; i++) {
                    if (inbetweenPositions[i] != ((i + 1) * 7) - 2) {//takes care of left gap getting too big
                        ++inbetweenPositions[i];
                    }
                }
            }
        }

        return max;
    }

    public static String createReadableString(int[] stationaryPositions, int[] inbetweenPositions, int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("0");
        }

        for (int i = 0; i < stationaryPositions.length; i++) {
            stringBuilder.replace(stationaryPositions[i], stationaryPositions[i] + 1, "v");
        }

        for (int i = 0; i < inbetweenPositions.length; i++) {
            stringBuilder.replace(inbetweenPositions[i], inbetweenPositions[i] + 1, "v");
        }
        return stringBuilder.toString();
    }

    public static int[] getInbetweenPointerPositions(int[] pointerPositions) {
        int[] inbetweenPointerPositions = new int[pointerPositions.length];
        for (int i = 0; i < pointerPositions.length; i++) {
            inbetweenPointerPositions[i] = pointerPositions[i] - 6;
        }
        return inbetweenPointerPositions;
    }

    public static int[] getStationaryPointerPositions(int length) {
        int initialPointers = length / 7;
        int[] pointerPositions = new int[initialPointers];
        for (int i = 0; i < initialPointers; i++) {
            pointerPositions[i] = ((i + 1) * 7) - 1;
        }
        return pointerPositions;
    }

    //  v                            v
    //       v
    //            v
    //                 v
    //                      v
    //                           v
    // -1, -321, -21, -21, -21, -9, -1]
    private int getMaxFrom7(int[] ints) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < ints.length - 1; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        if (ints[0] + ints[6] > max) {
            max = ints[0] + ints[6];
        }
        return max;
    }

    private static int getMaxFrom6(int[] ints) {
        int max = ints[0];
        for (int i = 1; i < ints.length; i++) {
            if (ints[i] > max) {
                max = ints[i];
            }
        }
        return max;
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
