package leetcode.fourSum;

import java.util.*;


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Long> check = new HashSet<>();

        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                int twoKey = nums[i1] + nums[i2];
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    int threeKey = twoKey + nums[i3];
                    for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                        long id = createDistinctHashKey(nums[i1], nums[i2], nums[i3], nums[i4]);
                        if (!check.contains(id)
                                && threeKey + nums[i4] == target) {
                            result.add(List.of(nums[i1], nums[i2], nums[i3], nums[i4]));
                            check.add(id);
                        }
                    }
                }
            }
        }
        return result;
    }

    private long createDistinctHashKey(int i1, int i2, int i3, int i4) {
        int[] arr = {i1, i2, i3, i4};
        Arrays.sort(arr);

        long h = 0xcbf29ce484222325L;
        for (int x : arr) {
            h ^= x;
            h *= 0x100000001b3L;
        }
        return h;
    }
}

