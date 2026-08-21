// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         // LOGIC 
//         int[] result = new int[2];
//         for(int i = 0; i < nums.length -1; i++) {
//             for(int j = i + 1; j < nums.length; j++) {
//                 if(nums[i] + nums[j] == target) {
//                     return new int[] {i, j};
//                 }
//             }
//         }
//         return result;
//     }
// }
// // TC:- O(n^2)
// // SC:- O(1)

//optimal approach
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i <= nums.length-1; i++) {
            int need = target - nums[i];

            if(map.containsKey(need)) {
                return new int[] {map.get(need), i};
            }

            map.put(nums[i], i);
        }

        return new int[] {};
    }
}