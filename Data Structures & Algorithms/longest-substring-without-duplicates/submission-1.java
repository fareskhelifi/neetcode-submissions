class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        int[] occ = new int[128];

        int l = 0, r = 0;
        while (r < s.length()) {
            int charIndex = s.charAt(r);
            occ[charIndex]++;

            while (occ[charIndex] > 1) {
                int leftCharIndex = s.charAt(l);
                occ[leftCharIndex]--;
                l++;
            }
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
