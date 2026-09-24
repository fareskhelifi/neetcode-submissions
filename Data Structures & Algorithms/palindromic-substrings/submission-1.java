class Solution {
    private int result = 0;
    public int countSubstrings(String s) {
        
        for (int i = 0; i < s.length(); i++) {
            expandFromCenter(i, i, s);
            expandFromCenter(i, i + 1, s);
        }
        return result;
    }

    private void expandFromCenter(int l, int r, String s) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
            result++;
        }
    }
}
