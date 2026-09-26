class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> scount = new HashMap<>();

        for (char c : s.toCharArray()) {
            scount.put(c, scount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> tcount = new HashMap<>();
        
        for (char c : t.toCharArray()) {
            tcount.put(c, tcount.getOrDefault(c, 0) + 1);
        }

        return tcount.equals(scount);
    }
}
