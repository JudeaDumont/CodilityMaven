package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;

//first, to get better time performance, I will need to figure out why they are being duplicated
// and fix it such that !jumpPatternSets.contains(newJumpPattern) is not necessary.
// and then therefore, that container is not necessary.

//actually I am going to use the above pattern to make sure all the jump patterns are met.
// and store them via string in a hashtable
public class SolitaireNumbers {
    public static ArrayList<ArrayList<Integer>> solitaireNumbers(int[] A) {
        //2^n-1 where n is length of A

        //first one is just all ones
        ArrayList<Integer> first = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            first.add(1);
        }


        //debug
        ArrayList<ArrayList<Integer>> allJumpPatterns = new ArrayList<>();
        allJumpPatterns.add(first);


        //relies on early return to not have superfluous iterations,
        // but it is close to Math.pow(2, A.length - 1),
        // with the weirdness being that there are no values above 6 in jump patterns
        double iterations = Math.pow(2, A.length - 1);

        //we work in jumpPatternSets, removing the ones we have worked through already.
        ArrayList<ArrayList<Integer>> currentJumpPatternSet = new ArrayList<>();
        currentJumpPatternSet.add(first);

        ArrayList<ArrayList<Integer>> nextSet;

        while (currentJumpPatternSet.size()>0) {
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
                        //debug
                        allJumpPatterns.add(newJumpPattern);

                        //this is where we would call a function with the jump pattern
                        // and that function would be caching results per jump and doing a setmax etc.
                    }
                }
            }
            //now we want to move on to the next set
            currentJumpPatternSet = nextSet;
            int check = 0;
        }

        return allJumpPatterns;

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
    }
}
