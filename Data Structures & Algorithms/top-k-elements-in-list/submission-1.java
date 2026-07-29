class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for (Integer num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> map = count.entrySet().stream()
        .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
        .collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (oldValue, newValue) -> oldValue,
            LinkedHashMap::new
        ));

        List<Integer> rez = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {break ;}
            System.out.println("value: " + entry.getKey() + " : " + entry.getValue());
            rez.add(entry.getKey());
            k--;
        }

        return rez.stream().mapToInt(Integer::intValue).toArray();
    }
}
