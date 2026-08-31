class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Map.Entry<int[], Double>> pq = new PriorityQueue<>(
            Comparator.comparingDouble(Map.Entry::getValue)
        );

        Map<int[], Double> map = new HashMap<>(); 

        for (int[] point : points) {
            int x1 = point[0], x2 = point[1];
            Double distance = Math.sqrt(Math.pow(x1, 2) + Math.pow(x2, 2));
            map.put(point, distance);
        }

        System.out.println(map);
        
        pq.addAll(map.entrySet());

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }

        return result;

    }
}
