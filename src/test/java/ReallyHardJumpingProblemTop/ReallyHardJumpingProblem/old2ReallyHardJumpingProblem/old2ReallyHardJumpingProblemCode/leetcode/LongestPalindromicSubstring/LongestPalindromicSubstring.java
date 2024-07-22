package ReallyHardJumpingProblemTop.ReallyHardJumpingProblem.old2ReallyHardJumpingProblem.old2ReallyHardJumpingProblemCode.leetcode.LongestPalindromicSubstring;

public class LongestPalindromicSubstring {
    public static String longestPalindromicSubstring(String s) {
        if (s.isEmpty()) {
            return "";
        } else if (s.length() == 1) {
            return s;
        } else if (s.length() == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return String.valueOf(s.charAt(0));
            }
        }

        int start = 0;
        int end = s.length() - 1;
        boolean run = true;

        String maxString = String.valueOf(s.charAt(0));
        boolean skip = false;

        while (run) {
            if (!skip && s.charAt(start) == s.charAt(end)) {
                //check palindrome
                boolean checkPalindrome = true;
                int startC = start + 1;
                int endC = end - 1;
                while (checkPalindrome) {
                    if (s.charAt(startC) == s.charAt(endC)) {
                        int distance = endC - startC;
                        if (distance == 2 || distance == 1 || distance == 0 || distance == -1) {
                            //palindrome
                            String palindrome = s.substring(start, end + 1);
                            if(palindrome.length() > maxString.length()){
                                maxString = palindrome;
                            }
                            checkPalindrome = false;
                        } else {
                            ++startC;
                            --endC;
                        }
                    } else {
                        checkPalindrome = false;
                    }
                }
                skip = true;
            } else {
                skip = false;
                --end;
                if (start == end) {
                    end = s.length() - 1;
                    ++start;
                    if ((maxString.length() >= end - start + 1) || start == end) {
                        run = false;
                    }
                }
            }
        }
        return maxString;
    }
}
