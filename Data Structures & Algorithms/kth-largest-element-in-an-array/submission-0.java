class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = Arrays.stream(nums)
                        .boxed()
                        .collect(Collectors.toCollection(
                    () -> new PriorityQueue<>(Collections.reverseOrder())));

        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }

        return pq.peek();
    }
}
