class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numberNeeded = new HashMap<>();
        int diff; 
        for (int i = 0; i < nums.length; i++) {
            int numberRequired = nums[i];
            diff = target - numberRequired; 
            if (numberNeeded.containsKey(numberRequired)) {
                return new int[]{numberNeeded.get(numberRequired), i};
            }
            numberNeeded.put(diff, i);
        }
        return new int[]{0, 0};
    }
}
