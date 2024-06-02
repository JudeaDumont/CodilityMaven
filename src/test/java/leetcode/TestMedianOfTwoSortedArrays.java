package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.example.leetcode.MedianOfTwoSortedArrays.MedianOfTwoSortedArrays.findMedianSortedArrays;

public class TestMedianOfTwoSortedArrays {
    @Test
    void testFindMedianSortedArrays(){
        //         v
        //1, 2, 3, 4, 5, 6, 6
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 6}, new int[]{2, 3, 4, 5, 6});
        Assertions.assertEquals(medianSortedArrays, 4);
    }
    @Test
    void testFindMedianSortedArrays2(){
        //         v
        //1, 2, 3, 4, 5, 6, 6
        double medianSortedArrays = findMedianSortedArrays(new int[]{2, 3, 4, 5, 6}, new int[]{1, 6});
        Assertions.assertEquals(medianSortedArrays, 4);
    }
    @Test
    void testFindMedianSortedArrays3(){
        //               v
        //1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5});
        Assertions.assertEquals(medianSortedArrays, 3);
    }

    @Test
    void testFindMedianSortedArrays4(){
        //               v  v
        //1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2, 3, 4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6});
        Assertions.assertEquals(medianSortedArrays, 3.5);
    }

    @Test
    void testFindMedianSortedArrays5(){
        //
        //1, 2, 3
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        Assertions.assertEquals(medianSortedArrays, 2);
    }

    @Test
    void testFindMedianSortedArrays6(){
        //
        //1, 2, 3
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
        Assertions.assertEquals(medianSortedArrays, 2);
    }

    @Test
    void testFindMedianSortedArrays7(){
        //
        //1, 2, 3, 4
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        Assertions.assertEquals(medianSortedArrays, 2.5);
    }

    @Test
    void testFindMedianSortedArrays8(){
        //
        //1, 2, 3, 4
        double medianSortedArrays = findMedianSortedArrays(new int[]{}, new int[]{1});
        Assertions.assertEquals(medianSortedArrays, 1);
    }

    @Test
    void testFindMedianSortedArrays9(){
        //
        //1, 2, 3, 4
        double medianSortedArrays = findMedianSortedArrays(new int[]{1}, new int[]{});
        Assertions.assertEquals(medianSortedArrays, 1);
    }

    @Test
    void testFindMedianSortedArrays10(){
        //
        //1, 2, 3, 4
        double medianSortedArrays = findMedianSortedArrays(new int[]{1, 2}, new int[]{});
        Assertions.assertEquals(medianSortedArrays, 1.5);
    }

    @Test
    void testFindMedianSortedArrays11(){
        //
        //1, 2, 3, 4
        double medianSortedArrays = findMedianSortedArrays(new int[]{}, new int[]{1, 2});
        Assertions.assertEquals(medianSortedArrays, 1.5);
    }
}
