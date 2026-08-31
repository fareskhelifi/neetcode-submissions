class KthLargest {
    private PriorityQueue<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.nums = Arrays
            .stream(nums)
            .boxed()
            .collect(Collectors.toCollection(PriorityQueue::new));
        this.k = k;
    }
    
    public int add(int val) {
        this.nums.offer(val);
        while (this.nums.size() > k) {
            this.nums.poll();
        }
        return nums.peek();
    }
}
