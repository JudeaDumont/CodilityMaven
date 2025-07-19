package leetcode.fourSum;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<String> check = new HashSet<>();
        Map<String, Integer> memo = new HashMap<>();

        for (int i1 = 0; i1 < nums.length; i1++) {
            for (int i2 = i1 + 1; i2 < nums.length; i2++) {
                for (int i3 = i2 + 1; i3 < nums.length; i3++) {
                    for (int i4 = i3 + 1; i4 < nums.length; i4++) {
                        String id = createDistinct(nums[i1], nums[i2], nums[i3], nums[i4]);
                        int memoNum = checkMemo(nums, memo, i1, i2, i3, i4);
                        if (i1 != i2 && i2 != i3 && i3 != i4
                                && !check.contains(id)
                                && memoNum == target) {
                            result.add(List.of(nums[i1], nums[i2], nums[i3], nums[i4]));
                            check.add(id);
                        }
                    }
                }
            }
        }
        return result;
    }

    private static int checkMemo(int[] nums, Map<String, Integer> memo, int i1, int i2, int i3, int i4) {
        String threeKey = i1 + "," + i2 + "," + i3;
        if (memo.containsKey(threeKey)) {
            return memo.get(threeKey) + nums[i4];
        } else {
            String twoKey = i1 + "," + i2;
            if (memo.containsKey(twoKey)) {
                int threeValue = memo.get(twoKey) + nums[i3];
                memo.put(threeKey, threeValue);
                return threeValue + nums[i4];
            } else {
                int twoValue = nums[i1] + nums[i2];
                memo.put(twoKey, twoValue);
                int threeValue = twoValue + nums[i3];
                memo.put(threeKey, threeValue);
                return threeValue + nums[i4];
            }
        }
    }

    private String createDistinct(int i1, int i2, int i3, int i4) {
        int[] arr = {i1, i2, i3, i4};
        Arrays.sort(arr);
        return Arrays.stream(arr)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
