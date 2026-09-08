class Solution {
    private List<List<String>> partitions = new ArrayList<>();

    public List<List<String>> partition(String s) {
        dfs(0, s, new ArrayList<>());
        return partitions;
    }

    private void dfs(int start, String s, List<String> cur) {
        if (start == s.length()) {
            partitions.add(new ArrayList<>(cur));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                cur.add(substring);
                dfs(end + 1, s, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) return false;

            start++;
            end--;
        }
        return true;
    }
}
