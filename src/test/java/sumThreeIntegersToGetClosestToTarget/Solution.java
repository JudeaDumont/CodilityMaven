package sumThreeIntegersToGetClosestToTarget;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Sort the array
        int n = nums.length;
        int closestSum = nums[0] + nums[1] + nums[2]; // Initialize the closest sum
        int minDiff = Math.abs(closestSum - target); // Initialize the minimum difference

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                int currentDiff = currentSum - target;

                // Check if the current sum is closer to the target
                int currDiffAbs = Math.abs(currentDiff);
                if (currDiffAbs < minDiff) {
                    closestSum = currentSum;
                    minDiff = currDiffAbs;
                }

                if (currentDiff < 0) {
                    left++; // Move the left pointer to the right
                } else if (currentDiff > 0) {
                    right--; // Move the right pointer to the left
                } else {
                    return currentSum; // Exact match found
                }
            }
        }

        return closestSum;
    }
}
