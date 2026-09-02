class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    void backtrack(int[] nums, int start, List<Integer> list) {

        result.add(new ArrayList<>(list));

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            list.add(nums[i]);

            backtrack(nums, i + 1, list);

            list.remove(list.size() - 1);
        }
    }
}