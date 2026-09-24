class Solution {
    private String result = "";
    private int resultLength = 0;

    public String longestPalindrome(String s) {
        int l, r;
        for (int i = 0; i < s.length(); i++) {
            expandFromCenter(s, i, i);
            expandFromCenter(s, i, i + 1);
        }
        return result;
    }

    private void expandFromCenter(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                if (r - l + 1 > resultLength) {
                    resultLength = r - l + 1;
                    result = s.substring(l, r + 1);
                }
            l--;
            r++;
        }
    }
}
