class Solution {
    public boolean hasDuplicate(int[] nums) {
        int current = 0;
       while (current < nums.length - 1) {
            for (int i = current + 1; i < nums.length; i++) {
                if (nums[i] == nums[current]) {return true;}
            } 
            current++;
       }
       return false;
 
    }
}
