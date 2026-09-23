class Solution {
    private int[] cache;

    public int rob(int[] nums) {
        cache = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }
        return dfs(0, nums);
    }

    private int dfs(int i, int[] nums) {
        if (i >= nums.length) {
            return 0;
        }
        if (cache[i] != -1) return cache[i];

        return cache[i] = Math.max(nums[i] + dfs(i + 2, nums), dfs(i + 1, nums));
    }
}
