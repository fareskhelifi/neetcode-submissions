class Solution {
    public int maxArea(int[] heights) {
        int result = 0;

        int left = 0, right = heights.length - 1;
        int width, height;

        while (left < right) {
            width = right - left;
            height = Math.min(heights[left], heights[right]); 
            result = Math.max(result, width * height);
            if (heights[left] >= heights[right]) {
                right--;
            } else {
                left++;
            }
        }

        return result;
    }
}
