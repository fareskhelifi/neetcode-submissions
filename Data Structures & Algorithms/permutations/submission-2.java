class Solution {
    List<List<Integer>> result = new ArrayList<>();
    
    public List<List<Integer>> permute(int[] nums) {
        dfs(new ArrayList<>(), nums);
        return result;
    }

    private void dfs(List<Integer> curr, int[] nums) {
        if (curr.size() == nums.length) {
            if (isValid(curr)) {
                result.add(new ArrayList<>(curr));
            }
            return;
        }

        for (int num : nums) {
            if (curr.contains(num)) continue;
            curr.add(num);
            dfs(curr, nums);
            curr.remove(curr.size() - 1);
        }
    }

    private boolean isValid(List<Integer> l) {
        return new HashSet<>(l).size() == l.size();
    }
}
