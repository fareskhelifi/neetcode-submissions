class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        Set<Integer> visitSet = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visitSet)) return false;
        }
        return true;
    }

    private boolean dfs(int course, Set<Integer> visitSet) {
        if (adj.get(course).size() == 0) return true;
        if (visitSet.contains(course)) return false;
        
        visitSet.add(course);

        for (int pre : adj.get(course)) {
            if (!dfs(pre, visitSet)) return false;
        }

        visitSet.remove(course);
        adj.put(course, new ArrayList<>());
        return true;
    }
}
