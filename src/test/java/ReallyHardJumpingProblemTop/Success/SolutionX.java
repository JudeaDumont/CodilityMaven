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
                int ik = i + k;
                if (ik < N) {
                    int next = dp[i] + A[ik];
                    dp[ik] = Math.max(dp[ik], next);
                }
            }
        }

        return dp[N - 1];
    }
}
