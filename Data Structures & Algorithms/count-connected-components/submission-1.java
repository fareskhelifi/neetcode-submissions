class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visit = new HashSet<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (!visit.contains(i)) {
                dfs(i, -1, adj, visit);
                result++;
            }
        }
        return result;
    }

    public void dfs(int node, int prevNode, Map<Integer, List<Integer>> adj, Set<Integer> visit) {
        if (!visit.add(node)) return;
        for (int child : adj.get(node)) {
            if (child == prevNode) continue;
            dfs(child, node, adj, visit);
        }
    }
}
