class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> exists = new HashSet<>();

        for (int number : nums) {
            if (exists.contains(number)) {
                return true;
            }
            exists.add(number);
        }
        return false;
    }
}