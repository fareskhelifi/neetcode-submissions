class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(0, new ArrayList<>(), nums);
        return result;
    }

    private void dfs(int i, List<Integer> cur, int[] nums) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[i]);
        dfs(i + 1, cur, nums);
        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, nums);
    }
}
