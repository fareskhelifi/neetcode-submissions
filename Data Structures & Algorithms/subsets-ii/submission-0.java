class Solution {
    private List<List<Integer>> subsets = new ArrayList<>();
    
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), nums);
        return subsets;
    }

    private void dfs(int i, List<Integer> cur, int[] nums) {
        if (i >= nums.length) {
            subsets.add(new ArrayList<>(cur));
            return;
        }

        cur.add(nums[i]);
        dfs(i + 1, cur, nums);

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
            i++;
        }

        cur.remove(cur.size() - 1);
        dfs(i + 1, cur, nums);
    }
}
