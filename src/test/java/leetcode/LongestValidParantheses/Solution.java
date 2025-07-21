package leetcode.LongestValidParantheses;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int max_len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else { //this runs every time a set of valid parentheses is encountered
                    max_len = Math.max(max_len, i - stack.peek());
                }
            }
        }

        return max_len;        
    }
}
