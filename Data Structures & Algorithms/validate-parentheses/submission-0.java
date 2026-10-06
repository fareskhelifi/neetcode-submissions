class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        Map<Character, Character> map = Map.of(
            '{' , '}',
            '(' , ')',
            '[' , ']'
        );

        for (Character c : s.toCharArray()) {
            if (!stack.isEmpty() && map.containsKey((stack.peek())) 
            && (map.get(stack.peek()) == c)) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
