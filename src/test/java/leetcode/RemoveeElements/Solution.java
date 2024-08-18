package leetcode.RemoveeElements;

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int last = nums.length;
        for (int i = 0; i < last; i++) {
            if (nums[i] == val) {
                --last;
                int l = last;
                while (l != i && nums[l] == val) {
                    --l;
                    --last;
                }
                nums[i] = nums[l];
                nums[l] = val;
            }
        }
        return last;
    }
}

// v
// 3, 2, 2, 3

