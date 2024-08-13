package leetcode.WellFormedParanthesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Stack<State> stack = new Stack<>();
        stack.push(new State(new StringBuilder(), 0, 0));

        while (!stack.isEmpty()) {
            State current = stack.pop();

            if (current.sb.length() == n * 2) {
                res.add(current.sb.toString());
                continue;
            }

            if (current.open < n) {
                stack.push(new State(new StringBuilder(current.sb).append('('), current.open + 1, current.close));
            }

            if (current.close < current.open) {
                stack.push(new State(new StringBuilder(current.sb).append(')'), current.open, current.close + 1));
            }
        }

        return res;
    }

    static class State {
        StringBuilder sb;
        int open;
        int close;

        State(StringBuilder sb, int open, int close) {
            this.sb = sb;
            this.open = open;
            this.close = close;
        }
    }
}