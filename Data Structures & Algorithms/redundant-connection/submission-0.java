class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = edges.length;

        for (int i = 1; i <= n; i++) {
            adj.put(i, new ArrayList<>());
        }

        int skip = n - 1;
        while (skip >= 0) {
            for (int i = 0; i < n; i++) {
                if (skip == i) continue;

                adj.get(edges[i][0]).add(edges[i][1]);
                adj.get(edges[i][1]).add(edges[i][0]);  
            }

            Set<Integer> visit = new HashSet<>();
            if (dfs(1, 0, visit, adj) && visit.size() == n) return edges[skip];
            skip--;
            adj = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                adj.put(i, new ArrayList<>());
            }
        }
        return edges[0];
    }

    private boolean dfs(int node, int prevNode, Set<Integer> visit, Map<Integer, List<Integer>> adj) {
        if (!visit.add(node)) {
            return false;
        }

        for (int child : adj.get(node)) {
            if (child == prevNode) continue;
            if (!dfs(child, node, visit, adj)) return false;
        }
        return true;
    }
}
