package leetcode.allpossiblephonenumberstrings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    private final Map<Character, String> numbersToStrings = new HashMap<>();

    public void initialize() {
        numbersToStrings.put('2', "abc");
        numbersToStrings.put('3', "def");
        numbersToStrings.put('4', "ghi");
        numbersToStrings.put('5', "jkl");
        numbersToStrings.put('6', "mno");
        numbersToStrings.put('7', "pqrs");
        numbersToStrings.put('8', "tuv");
        numbersToStrings.put('9', "wxyz");
    }

    public List<String> letterCombinations(String S) {
        List<String> list = new ArrayList<String>();
        if(S.isEmpty()){
            return list;
        }
        if(numbersToStrings.isEmpty()){
            initialize();
        }

        StringBuilder r0 = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            r0.append(numbersToStrings.get(S.charAt(i)).charAt(0));
        }
        list.add(r0.toString());
        StringBuilder rLast = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            rLast.append(numbersToStrings.get(S.charAt(i)).charAt(numbersToStrings.get(S.charAt(i)).length() - 1));
        }
        list.add(rLast.toString());
        StringBuilder theRest = new StringBuilder(r0);
        while (true) {
            int l = 0;
            theRest.setCharAt(l, (char) (theRest.charAt(l) + 1));
            if (theRest.toString().contentEquals(rLast)) {
                return list;
            }
            while (theRest.charAt(l) > rLast.charAt(l)) {
                theRest.setCharAt(l, r0.charAt(l));
                ++l;
                theRest.setCharAt(l, (char) (theRest.charAt(l) + 1));
            }
            list.add(theRest.toString());
        }
    }
}
