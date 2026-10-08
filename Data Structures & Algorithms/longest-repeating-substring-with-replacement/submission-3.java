class Solution {
    public int characterReplacement(String s, int k) {
        int res = 0, l = 0;
        int[] occ = new int[26];
        int maxOcc = 0;

        for (int r = 0; r < s.length(); r++) {
            int index = s.charAt(r) - 'A';
            occ[index]++;

            maxOcc = Math.max(maxOcc, occ[index]);

            if ((r - l + 1) - maxOcc > k) {
                occ[s.charAt(l) - 'A']--;
                l++;
            }

            res = Math.max(res, (r - l + 1));
        }
        return res;
    }
}
