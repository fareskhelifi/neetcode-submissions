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

        String pattern = "\\$faresEncoding\\$"; 
        String[] parts = str.split(pattern, -1); 

        return Arrays.asList(parts);
    }
}
