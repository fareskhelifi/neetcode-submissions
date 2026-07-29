class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> pos = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (pos.containsKey(nums[i])) {
                return new int[]{pos.get(nums[i]), i};
            }
            pos.put(target - nums[i], i);
        }
        return new int[]{0};
    }
}
