class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder(); 

        for (String str: strs) {
            sb.append(str.length() + "#" + str);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        List<String> strs = new ArrayList<>();
        
        int i = 0;
        while (i < str.length()) {
            
            StringBuilder curr = new StringBuilder();

            int length = getLength(str, i);
            int start = i + String.valueOf(length).length() + 1;

            for (int j = start; j < start + length; j++) {
                curr.append(str.charAt(j));
            }

            strs.add(curr.toString());

            i += length + String.valueOf(length).length() + 1;
        }

        return strs;
    }

    private int getLength(String str, int i) {
        StringBuilder sb = new StringBuilder();
        while (str.charAt(i) != '#') {
            sb.append(str.charAt(i));
            i++;
        }
        return Integer.parseInt(sb.toString());
    }
}
