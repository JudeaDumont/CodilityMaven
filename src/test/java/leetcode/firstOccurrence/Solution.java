package leetcode.firstOccurrence;

import org.junit.jupiter.api.Assertions;

class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null ||
                needle == null ||
                haystack.length() < needle.length()) return -1;

        for (int i = 0; i < haystack.length(); i++) {
            if(i+needle.length() > haystack.length()) return -1;
            if(needle.charAt(0)==haystack.charAt(i)){
                boolean found = true;
                for (int i1 = 1; i1 < needle.length(); i1++) {
                    if (needle.charAt(i1) != haystack.charAt(i + i1)) {
                        found = false;
                        break;
                    }
                }
                if(found) return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        Assertions.assertEquals(2,solution.strStr("hello", "ll"));
    }
}