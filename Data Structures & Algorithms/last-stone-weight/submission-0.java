class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pqStones = Arrays
                .stream(stones)
                .boxed()
                .collect(Collectors.toCollection(
                    () -> new PriorityQueue<>(Collections.reverseOrder())));
        
        while (pqStones.size() > 1) {
            int x = pqStones.poll();
            int y = pqStones.poll();
            if (x < y) {
                pqStones.offer(y - x);
            } else if (x > y) {
                pqStones.offer(x - y);
            }
        }
        System.out.println(pqStones.size());

        return pqStones.size() == 1 ? pqStones.peek() : 0;
        
    }
}
