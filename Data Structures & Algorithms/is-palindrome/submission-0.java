class Solution {
    public boolean isPalindrome(String s) {
        String nonWhiteSpaceString = Arrays.stream(s.split("\\s+"))
                .map(String::strip)
                .map(str -> str.replaceAll("[^a-zA-Z0-9]", ""))
                .collect(Collectors.joining());

        int len = nonWhiteSpaceString.length();

        for (int i = 0; i < len / 2; i++) {
            if (nonWhiteSpaceString.toLowerCase().charAt(i) != nonWhiteSpaceString.toLowerCase().charAt(len - 1 - i)) {
                System.out.println(nonWhiteSpaceString.charAt(i) + " vs " + nonWhiteSpaceString.charAt(len - 1 - i));
                return false;
            }
        }
        return true;
    }
}
