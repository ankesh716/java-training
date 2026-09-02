class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int end = Integer.MIN_VALUE;

        for (int[] in : intervals) {
            if (in[0] < end) {
                count++;
            } else {
                end = in[1];
            }
        }

        return count;
    }
}