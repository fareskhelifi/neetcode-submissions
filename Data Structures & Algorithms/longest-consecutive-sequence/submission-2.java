class Solution {
    public int longestConsecutive(int[] nums) {
        int result = 0;
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int length = 0;
                while (numSet.contains(num + length)) {
                    length++;
                }
                result = Math.max(result, length);
            }
        }
        return result;
    }
}
