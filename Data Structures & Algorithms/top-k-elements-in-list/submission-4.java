class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occ = new HashMap<>();
        for (int num : nums) {
            occ.put(num, occ.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(b[1], a[1])
        );

        for (Map.Entry<Integer, Integer> element : occ.entrySet()) {
            pq.offer(new int[]{ element.getKey(), element.getValue() });
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;
    }
}
