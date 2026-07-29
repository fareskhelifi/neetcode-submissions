class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] postfix = new int[nums.length];
        int[] res = new int[nums.length];

        prefix[0] = nums[0];
        postfix[nums.length - 1] = nums[nums.length - 1];

        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
            postfix[nums.length - 1 - i] = nums[nums.length - 1 - i] * postfix[nums.length - i];  
        }
        
        res[0] = postfix[1];
        res[nums.length - 1] = prefix[nums.length - 2];
        
        for (int i = 1; i < nums.length - 1; i++) {
            res[i] = prefix[i - 1] * postfix[i + 1];
        }

        return res;
    }
}  
