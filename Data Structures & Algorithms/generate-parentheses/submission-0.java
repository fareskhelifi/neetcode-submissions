class Solution {
    private List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        dfs(new StringBuilder(), 0, 0, n);
        return result;
    }

    private void dfs(StringBuilder sb, int open, int close, int n) {
        if (open == n && close == n) {
            result.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append("(");
            dfs(sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(")");
            dfs(sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        
    }

    private boolean isValid(String str) {
        Deque<Character> s = new ArrayDeque<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i); 

            if (!s.isEmpty() && c == ')' && s.peek() == '(') {
                s.pop();
            } else {
                s.push(c);
            }
        }

        return s.isEmpty();
    }
}
