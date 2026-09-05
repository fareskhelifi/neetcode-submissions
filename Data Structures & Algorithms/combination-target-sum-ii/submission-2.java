class Solution {

    private Set<List<Integer>> result = new HashSet<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> cur = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, cur, 0, candidates, target);
        return new ArrayList<>(result);
    }

    public void dfs(int i, List<Integer> cur, int total, int[] candidates, 
                    int target) {
        
        if (total == target) {
            result.add(new ArrayList<>(cur));
            return;
        }
        if (i > candidates.length - 1 || total > target) {
            return;
        }
        cur.add(candidates[i]);
        dfs(i + 1, cur, total + candidates[i], candidates, target);
        cur.remove(cur.size() - 1);

        while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
            i++;
        }
        dfs(i + 1, cur, total, candidates, target);
    }
}
