class Solution {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private List<Integer> order = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }

        
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited)) {
                return new int[]{};
            }
        }
        return order.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int course, Set<Integer> visited) {
        if (adj.get(course).size() == 0) {
            if (!order.contains(course)) {
                order.add(course);
            }
            return true;
        }
        if (visited.contains(course)) {
            return false;
        }

        visited.add(course);

        for (int pre : adj.get(course)) {
            if (!dfs(pre, visited)) return false;
        }

        visited.remove(course);
        adj.put(course, new ArrayList<>());
        if (!order.contains(course)) {
            order.add(course);
        }
        return true;
    }
}
