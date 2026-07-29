class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()) return null;
        if (strs.size() == 1) return strs.get(0);
        String joined = String.join("$faresEncoding$", strs);
        return joined.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        
        if (Objects.isNull(str)) { 
            return new ArrayList<>();
        };

        if (str.length() == 0) { 
            res.add("");
            return res;
        };

        String pattern = new String("$faresEncoding$");
        StringBuilder currentStr = new StringBuilder();
        
        for (int i = 0; i < str.length(); i++) {
            currentStr.append(str.charAt(i));

            if (currentStr.length() >= pattern.length() 
            && currentStr.substring(currentStr.length() - pattern.length()).equals(pattern)) {
                res.add(currentStr.substring(0, currentStr.length() - pattern.length()));
                currentStr.setLength(0);
            } else if (i == str.length() - 1) {
                res.add(currentStr.toString());
            }
        }
        return res;
    }
}
