class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;
        int max = nums[0];
        int min = nums[0];
        int curMax = 0;
        int curMin = 0;

        for (int n : nums) {
            curMax = Math.max(n, curMax + n);
            max = Math.max(max, curMax);

            curMin = Math.min(n, curMin + n);
            min = Math.min(min, curMin);

            total += n;
        }

        if (max < 0)
            return max;

        return Math.max(max, total - min);
    }
}