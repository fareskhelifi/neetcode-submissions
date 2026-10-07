class Solution {
    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0, right = nums.length - 1;
        int mid;

        while (left <= right) {
            mid = (right - left) / 2;
            if (nums[left] < nums[right]) {
                return Math.min(result, nums[left]);
            }

            mid = left + (right - left) / 2;
            result = Math.min(result, nums[mid]);
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
