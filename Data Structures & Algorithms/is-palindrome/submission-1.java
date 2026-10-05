class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
        }
        String sParsed = sb.toString().toLowerCase();
        System.out.println(sParsed);
        int front = 0, back = sParsed.length() - 1;
        while (front < back) {
            if (sParsed.charAt(front) != sParsed.charAt(back)) {
                System.out.println(sParsed.charAt(front));
                return false;
            }
            front++;
            back--;
        }
        return true;
    }
}
