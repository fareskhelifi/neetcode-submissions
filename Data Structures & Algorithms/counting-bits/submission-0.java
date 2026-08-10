class Solution {
    public int[] countBits(int n) {
        List<Integer> res = new ArrayList<>();

        while (n >= 0) {
            res.add(countOnes(n));
            n--;
        }

        Collections.reverse(res);
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public int countOnes(int n) {
        int numberOfOnes = 0;
        while (n != 0) {
            n &= n - 1;
            numberOfOnes++;
        }
        return numberOfOnes;
    }
}
