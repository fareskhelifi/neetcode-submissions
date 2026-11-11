class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private Set<Integer> visited = new HashSet<>();
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] node : edges) {
            adj.get(node[0]).add(node[1]);
            adj.get(node[1]).add(node[0]);
        }

        return dfs(0, -1) && visited.size() == n;
    }

    private boolean dfs(int node, int prevNode) {
        if (!visited.add(node)) {
            return false;
        }
        
        for (int child : adj.get(node)) {
            if (child == prevNode) continue;

            if (!dfs(child, node)) return false;
        }
        
        return true;
    }
}
