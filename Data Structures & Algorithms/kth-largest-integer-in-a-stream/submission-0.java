class KthLargest {
    private List<Integer> nums;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.nums = Arrays
            .stream(nums)
            .boxed()
            .collect(Collectors.toCollection(ArrayList::new));
        this.k = k;
    }
    
    public int add(int val) {
        this.nums.add(val);
        Collections.sort(nums, Collections.reverseOrder());
        return nums.get(k - 1);
    }
}
