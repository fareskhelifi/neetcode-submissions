class Solution {
    public int[] productExceptSelf(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int currentProd = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {
                    currentProd *= nums[j];
                }
            }
            res.add(currentProd);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}  
