class Solution {
    private int[][] cache;
    public int lengthOfLIS(int[] nums) {
        cache = new int[nums.length][nums.length + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return dfs(0, -1, nums);
    }

    private int dfs(int i, int prevIndex, int[] nums) {
        if (i >= nums.length) return 0;

        if (cache[i][prevIndex + 1] != -1) return cache[i][prevIndex + 1];

        if ((prevIndex != -1 && nums[i] > nums[prevIndex]) || prevIndex == -1) {
            return cache[i][prevIndex + 1] = Math.max(
                    1 + dfs(i + 1, i, nums), 
                    dfs(i + 1, prevIndex, nums)
                );
        } else {
            return cache[i][prevIndex + 1] = dfs(i + 1, prevIndex, nums);
        }

    }
}
