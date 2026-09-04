class Solution {
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> cur = new ArrayList<>();
        dfs(0, cur, 0, nums, target);
        return result;
    }

    public void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            result.add(new ArrayList(cur));
            return;
        }
        if (i >= nums.length || total > target) {
            return;
        }

        cur.add(nums[i]);
        dfs(i, cur, total + nums[i], nums, target);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, total, nums, target);
    }
}
