class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            List<Integer> iSequence = new ArrayList<>();
            iSequence.add(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] - nums[j - 1] == 1) {
                    iSequence.add(nums[j]);
                } else if (nums[j] - nums[j - 1] == 0) {
                    continue;
                } else { break;}
            }
            map.put(iSequence.size(), iSequence);
        }
        int max = -1;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if(entry.getKey() >= max) {
                max = entry.getKey();
                System.out.println(entry.getKey() + " : " + entry.getValue());
            }
        }
        return max;
    }
}
