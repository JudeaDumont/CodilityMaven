package org.example;

import java.util.ArrayList;
import java.util.Hashtable;

//first, to get better time performance, I will need to figure out why they are being duplicated
// and fix it such that !jumpPatternSets.contains(newJumpPattern) is not necessary.
// and then therefore, that container is not necessary.

//actually I am going to use the above pattern to make sure all the jump patterns are met.
// and store them via string in a hashtable
public class SolitaireNumbers {

    public static Long max = null;
    public static Hashtable<String, Long[]> memo = new Hashtable<>();

    public static ArrayList<Integer> chosenJumpPattern = null;

    public static Long traverseMemoizeAndFindMax(int[] a, ArrayList<Integer> newJumpPattern) {
        int j = 0;

        //look for the memo
        Long memoMax = null;
        int k = 0;
        for (int i = newJumpPattern.size() - 1; i > -1; i--) { //reverse iteration will find best match faster
            if (memo.containsKey(newJumpPattern.subList(0, i).toString())) {
                Long[] totalAtJump = memo.get(newJumpPattern.subList(0, i).toString());
                memoMax = totalAtJump[0];
                j = Math.toIntExact(totalAtJump[1]);
                k = i - 1;
                break;
            }
        }
        long total = a[0];
        if (memoMax != null) {
            total = memoMax; //always happens because of how the memos will be set. 0 will always be set.
        }

        ArrayList<Integer> newMemo = new ArrayList<>(newJumpPattern.subList(0, k));
        for (; k < newJumpPattern.size(); ++k) {
            newMemo.add(newJumpPattern.get(k));
            memo.put(newMemo.toString(), new Long[]{total, (long) j});
            j += newJumpPattern.get(k);
            total += a[j];
            int pause = 0;
        }
        if (max == null || total > max) {
            max = total;
            chosenJumpPattern = newJumpPattern;
        }
        return max;
    }

    public static Long solitaireNumbers(int[] A) {
        //2^n-1 where n is length of A

        //first one is just all ones
        ArrayList<Integer> first = new ArrayList<>();
        for (int i = 0; i < A.length - 1; ++i) {
            first.add(1);
        }

        //first call to the actual traversal method
        traverseMemoizeAndFindMax(A, first);

        //relies on early return to not have superfluous iterations,
        // but it is close to Math.pow(2, A.length - 1),
        // with the weirdness being that there are no values above 6 in jump patterns
        double iterations = Math.pow(2, A.length - 1);

        //we work in jumpPatternSets, removing the ones we have worked through already.
        ArrayList<ArrayList<Integer>> currentJumpPatternSet = new ArrayList<>();
        currentJumpPatternSet.add(first);

        ArrayList<ArrayList<Integer>> nextSet;

        while (currentJumpPatternSet.size() > 0) {
            nextSet = new ArrayList<>();
            for (int i = 0; i < currentJumpPatternSet.size(); ++i) {
                for (int j = 0; j < currentJumpPatternSet.get(i).size() - 1; ++j) {
                    ArrayList<Integer> newJumpPattern = new ArrayList<>(currentJumpPatternSet.get(i));
                    int end = newJumpPattern.get(newJumpPattern.size() - 1);
                    newJumpPattern.remove(newJumpPattern.size() - 1);
                    int newValue = currentJumpPatternSet.get(i).get(j) + end;
                    if (newValue > 6) {
                        continue;
                    }
                    newJumpPattern.set(j, newValue);
                    if (!nextSet.contains(newJumpPattern)) {
                        nextSet.add(newJumpPattern);

                        traverseMemoizeAndFindMax(A, newJumpPattern);
                        //this is where we would call a function with the jump pattern
                        // and that function would be caching results per jump and doing a setmax etc.

                    }
                }
            }
            //now we want to move on to the next set
            currentJumpPatternSet = nextSet;
        }

        //                      1, 1, 1, 1, 1
        //                      2, 1, 1, 1,
        //                      1, 2, 1, 1
        //                      1, 1, 2, 1
        //                      1, 1, 1, 2
        //                      2, 2, 1
        //                      2, 1, 2
        //                      1, 2, 2
        //                      3, 1, 1
        //                      1, 3, 1
        //                      1, 1, 3
        //                      3, 2
        //                      2, 3
        //                      4, 1
        //                      1, 4
        //                      5

        //                      1, 1, 1, 1
        //                      2, 1, 1
        //                      1, 2, 1
        //                      1, 1, 2
        //                      2, 2
        //                      3, 1
        //                      1, 3
        //                      4

        //first is              1, 1, 1
        //then it needs to be   2, 1
        //then                  1, 2
        //then                  3
        return max;
    }
}
