class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxRate = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            maxRate = Math.max(maxRate, piles[i]);
        }
        int minRate = 1;
        int result = maxRate;
        

        while (minRate <= maxRate) {
            int k = (maxRate + minRate) / 2;
            long totalHours = 0;
            
            for (int pile : piles) {
                totalHours += Math.ceil((double) pile / k);
            }

            if (totalHours <= h) {
                result = k;
                maxRate = k - 1;
            } else {
                minRate = k + 1;
            }
        }
        return result;
    }
}
