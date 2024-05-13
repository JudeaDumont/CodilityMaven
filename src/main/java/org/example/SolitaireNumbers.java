package org.example;

import com.google.gson.Gson;

import java.util.ArrayList;

public class SolitaireNumbers {
    public static ArrayList<ArrayList<Integer>> solitaireNumbers(int[] A) {
        //2^n-1 where n is length of A

        //just one set of jump patterns so there is not as much memory overhead
        ArrayList<ArrayList<Integer>> jumpPatterns = new ArrayList<>();

        //first one is just all ones
        ArrayList<Integer> first = new ArrayList<>();
        for (int i = 0; i < A.length; ++i) {
            first.add(1);
        }
        jumpPatterns.add(first);

        //the rest
        int ALength = A.length;
        int[] steps = {1, 2, 3, 4, 5, 6};
        for (Long i = 0L; i < Math.pow(2, A.length - 1); ++i) { //relies on early return to not have superfluous iterations, but it is close to Math.pow(2, A.length - 1), with the weirdness being that there are no values above 6
            for (int j = 0; j < jumpPatterns.get(Math.toIntExact(i)).size() - 1 && j < jumpPatterns.get(Math.toIntExact(i)).size() - 1; ++j) {
                ArrayList<Integer> newJumpPattern = new ArrayList<>(jumpPatterns.get(Math.toIntExact(i)));
                int end = newJumpPattern.get(newJumpPattern.size() - 1);
                newJumpPattern.remove(newJumpPattern.size() - 1);
                int newValue = jumpPatterns.get(Math.toIntExact(i)).get(j) + end;
                if (newValue > 6) {
                    if (jumpPatterns.size() == 125) {
                        int stop = 0;
                    }
                    //early return if i is over
                    if (i == jumpPatterns.size() - 1) {
                        Gson gson = new Gson();
                        String json = gson.toJson(jumpPatterns);

                        return jumpPatterns;
                    }
                    continue;
                }
                newJumpPattern.set(j, newValue);
                if (!jumpPatterns.contains(newJumpPattern)) {
                    jumpPatterns.add(newJumpPattern);
                }
            }
            //first, to get better time performance, I will need to figure out why they are being duplicated
            // and fix it such that !jumpPatterns.contains(newJumpPattern) is not necessary.
            // and then therefore, that container is not necessary.

            //actually I am going to use the above pattern to make sure all the jump patterns are met.
            // and store them via string in a hashtable
            int check = 0;
        }

        return jumpPatterns; //never hit

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
