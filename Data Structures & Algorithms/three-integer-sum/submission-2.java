class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length; i++) {
            int target = (-1) * nums[i];
            int front = i + 1, back = nums.length - 1;

            while (front < back) {
                int sum = nums[front] + nums[back];
                if (sum == target) {
                    result.add(new ArrayList<>(
                            List.of(nums[i], nums[front], nums[back]))
                        );
                        front++;
                        back--;
                } else if (sum > target) {
                    back--;
                } else {
                    front++;
                }
            }

        }
        return new ArrayList<>(result);
    }
}
