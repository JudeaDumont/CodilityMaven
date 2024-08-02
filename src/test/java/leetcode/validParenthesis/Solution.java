package leetcode.validParenthesis;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 != 0) return false; // Quick check for odd length strings

        char[] stack = new char[n];
        int top = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else if (c == ')' || c == '}' || c == ']') {
                if (top == -1) return false;
                char open = stack[top--];
                if ((c == ')' && open != '(') ||
                        (c == '}' && open != '{') ||
                        (c == ']' && open != '[')) {
                    return false;
                }
            }
        }
        return top == -1;
    }
}