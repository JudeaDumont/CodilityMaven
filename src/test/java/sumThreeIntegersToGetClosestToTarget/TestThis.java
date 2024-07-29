package sumThreeIntegersToGetClosestToTarget;

import org.junit.jupiter.api.Assertions;

public class TestThis {
    @org.junit.jupiter.api.Test
    public void test() {
        Solution solution = new Solution();
        int i = solution.threeSumClosest(
                new int[]{40, -53, 36, 89, -38, -51, 80, 11, -10, 76, -30, 46, -39, -15, 4, 72, 83, -25, 33, -69, -73, -100, -23, -37, -13, -62, -26, -54, 36, -84, -65, -51, 11, 98, -21, 49, 51, 78, -58, -40, 95, -81, 41, -17, -70, 83, -88, -14, -75, -10, -44, -21, 6, 68, -81, -1, 41, -61, -82, -24, 45, 19, 6, -98, 11, 9, -66, 50, -97, -2, 58, 17, 51, -13, 88, -16, -77, 31, 35, 98, -2, 0, -70, 6, -34, -8, 78, 22, -1, -93, -39, -88, -77, -65, 80, 91, 35, -15, 7, -37, -96, 65, 3, 33, -22, 60, 1, 76, -32, 22}
                , 292
        );
        Assertions.assertEquals(i, 291);
    }
}
