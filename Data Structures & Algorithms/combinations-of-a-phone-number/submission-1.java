class Solution {
    public static final Map<Character, List<Character>> KEYBORAD = Map.of(
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z')
        );

    private List<String> result = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        dfs(0, 0, digits, new StringBuilder());
        return result;
    }

    private void dfs(int indexDigits, int indexList, String digits, StringBuilder current) {
        if (indexDigits == digits.length()) {
            result.add(current.toString());
            return;
        }
        if (indexList == KEYBORAD.get(digits.charAt(indexDigits)).size()) {
            return;
        }

        current.append(KEYBORAD.get(digits.charAt(indexDigits)).get(indexList));
        dfs(indexDigits + 1, 0, digits, current);

        current.deleteCharAt(current.length() - 1);
        dfs(indexDigits, indexList + 1, digits, current);

    }
}
