class Solution {
    public int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        int result = 0;

        for (char c : str.toCharArray()) {
            if (c == '1') {
                result++;
            }
        }

        return result;
    }
}
