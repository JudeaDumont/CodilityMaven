package leetcode.fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<Integer>> result = new HashMap<>();

        Arrays.sort(nums);
        if (nums.length < 4) return new ArrayList<>();

        int i = 0;
        int l = 1;
        int r = nums.length - 1;
        int m = nums.length - 2;
        while (true) {
            int sum = nums[i] + nums[l] + nums[m] + nums[r];
            if (sum == target) {
                List<Integer> quad = List.of(nums[i], nums[l], nums[m], nums[r]);
                result.put(quad.hashCode(), quad);
                if (l + 1 != m) {
                    ++l;
                } else if (m + 1 != r) {
                    r--;
                } else if (i + 1 != l) {
                    ++i;
                    l = i + 1;
                    r = nums.length - 1;
                    if (l == r) {
                        return result.values().stream().toList();
                    }
                    m = nums.length - 2;
                } else {
                    //they are next to each other
                    return result.values().stream().toList();
                }
            } else if (sum < target) {
                if (l + 1 != m) {
                    ++l;
                } else if (i + 1 != l) {
                    //special case reset
                    ++i;
                    l = i + 1;
                    r = nums.length - 1;
                    if (l == r) {
                        return result.values().stream().toList();
                    }
                    m = nums.length - 2;
                } else if (r - 1 != m) {
                    --r;
                    //i, l and m are touching
                } else {
                    return result.values().stream().toList();
                }
            } else {
                //Sum is greater than target
                if (r - 1 != m) {
                    --r;
                } else if (m - 1 != l) {
                    --m;
                } else if (i + 1 != l) {
                    //l, m and r are touching
                    ++i;
                    l = i + 1;
                    r = nums.length - 1;
                    if (l == r) {
                        return result.values().stream().toList();
                    }
                    m = nums.length - 2;
                } else {
                    return result.values().stream().toList();
                }
            }
        }
    }
}
