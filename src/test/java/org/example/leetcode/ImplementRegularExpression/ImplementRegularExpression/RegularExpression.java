package org.example.leetcode.ImplementRegularExpression.ImplementRegularExpression;

import static org.example.util.print2DArray.printBooleans;

public class RegularExpression {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        String s1 = printBooleans(dp);

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                if (pChar == '.' || pChar == sChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                    s1 = printBooleans(dp);
                } else if (pChar == '*') {
                    dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (sChar == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
                    s1 = printBooleans(dp);
                }
            }
        }

        return dp[m][n];
    }
}
