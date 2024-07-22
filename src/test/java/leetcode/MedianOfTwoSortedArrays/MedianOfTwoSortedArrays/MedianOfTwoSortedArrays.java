package leetcode.MedianOfTwoSortedArrays.MedianOfTwoSortedArrays;

public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0;
        }

        int itemsCounted = 0;
        int totalItems = nums1.length + nums2.length;
        int odd = totalItems % 2;
        int itemsNeeded = (totalItems / 2) + odd;
        int i1 = -1;
        int i2 = -1;
        boolean true1false2 = true;

        while (itemsCounted != itemsNeeded) {
            if (i1 + 1 != nums1.length && (i2 + 1 == nums2.length || nums1[i1 + 1] <= nums2[i2 + 1])) {
                ++itemsCounted;
                ++i1;
                true1false2 = true;
            } else {
                ++itemsCounted;
                ++i2;
                true1false2 = false;
            }
        }


        if (odd == 1) {
            if (true1false2) return nums1[i1];
            else return nums2[i2];
        } else {
            if (odd == 0) {
                if (i2 + 1 != nums2.length && (i1 + 1 == nums1.length || nums1[i1 + 1] >= nums2[i2 + 1])) {
                    if (true1false2) {
                        return (double) (nums1[i1] + nums2[i2 + 1]) / 2;
                    } else {
                        return (double) (nums2[i2] + nums2[i2 + 1]) / 2;
                    }
                } else {
                    if (true1false2) {
                        return (double) (nums1[i1] + nums1[i1 + 1]) / 2;
                    } else {
                        return (double) (nums2[i2] + nums1[i1 + 1]) / 2;
                    }
                }
            }
        }
        return i1;
    }
}
