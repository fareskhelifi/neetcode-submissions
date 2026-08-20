class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int[] current = result.remove(result.size() - 1);
            if (interval[1] < current[0]) {
                result.add(interval);
                result.add(current);
            } else if (interval[0] > current[1]) {
                result.add(current);
                result.add(interval);
            } else {
                current[0] = Math.min(current[0], interval[0]);
                current[1] = Math.max(current[1], interval[1]);
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
        
    }
}
