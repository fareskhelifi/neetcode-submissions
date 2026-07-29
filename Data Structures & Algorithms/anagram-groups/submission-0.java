class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> anagrams = new ArrayList<>();
        int[] visited = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            String current = strs[i];
            List<String> currentAnagrams = new ArrayList<>();
            if (visited[i] == 1) { continue; }
            currentAnagrams.add(current);
            for (int j = i + 1; j < strs.length; j++) {
                if (validAnagrams(current, strs[j])) {
                    visited[j] = 1;
                    currentAnagrams.add(strs[j]);
                }
            }
            anagrams.add(currentAnagrams);
        }
        return anagrams;
    }

    public boolean validAnagrams(String s, String t) {
        if (s.length() != t.length()) {return false;}

        Map<Character, Integer> charCount = new HashMap<>();

        for (Character c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        for (Character c : t.toCharArray()) {
            if (charCount.containsKey(c) && charCount.get(c) > 0) {
                charCount.put(c, charCount.get(c) - 1);
            } else {
                return false;
            }
        }

        for (Integer count : charCount.values()) {
            if (count != 0) {return false;}
        }
        return true;
    }
}
