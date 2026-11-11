class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private Set<Integer> visitedNodes = new HashSet<>();
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] node : edges) {
            adj.get(node[0]).add(node[1]);
            adj.get(node[1]).add(node[0]);
        }

        Set<Integer> visit = new HashSet<>();
        if (!dfs(0, -1, visit)) return false;

        return visitedNodes.size() == n;
    }

    private boolean dfs(int node, int prevNode, Set<Integer> visit) {
        visitedNodes.add(node);
        if (adj.get(node).size() == 0) {
            return true;
        }
        if (visit.contains(node)) {
            return false;
        }
        
        visit.add(node);
        for (int child : adj.get(node)) {
            if (child != prevNode && !dfs(child, node, visit)) return false;
        }
        visit.remove(node);
        adj.put(node, new ArrayList<>());
        return true;
    }
}
