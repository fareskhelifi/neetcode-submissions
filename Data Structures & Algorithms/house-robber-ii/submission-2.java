class Solution {
    private int[] cache;

    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        cache = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }
        int first = dfs(1, nums.length, nums);

        for(int i = 0; i < nums.length; i++) {
            cache[i] = -1;
        }
        int second = dfs(0, nums.length - 1, nums);

        return Math.max(first, second);
    }

    private int dfs(int i, int end, int[] nums) {
        if (i >= end) return 0;
        if (cache[i] != -1) return cache[i];

        return cache[i] = Math.max(nums[i] + dfs(i + 2, end, nums), dfs(i + 1, end, nums));
    }
}
