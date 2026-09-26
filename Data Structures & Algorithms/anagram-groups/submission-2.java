class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String str : strs) {
            char[] strChar = str.toCharArray();
            Arrays.sort(strChar);
            String sortedStr = new String(strChar);

            anagrams.computeIfAbsent(sortedStr, k -> new ArrayList<>())
                .add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
