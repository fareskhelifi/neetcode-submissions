class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int front = 0, back = numbers.length - 1;
        while (front < back) {
            int sum = numbers[front] + numbers[back];
            if (sum == target) {
                return new int[] { front + 1, back + 1 };
            } else if (sum > target) {
                back--;
            } else {
                front++;
            }
        }
        return new int[] { 0, 0 };
    }
}
