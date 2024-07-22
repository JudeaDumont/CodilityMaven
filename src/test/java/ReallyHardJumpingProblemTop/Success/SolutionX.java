package ReallyHardJumpingProblemTop.Success;

import java.util.Arrays;

public class SolutionX {
    public int solution(int[] A) {
        int N = A.length;
        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = A[0];

        for (int i = 0; i < N; i++) {
            for (int k = 1; k <= 6; k++) {
                if (i + k < N) {
                    dp[i + k] = Math.max(dp[i + k], dp[i] + A[i + k]);
                }
            }
        }

        return dp[N - 1];
    }
}
