class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> perms = new ArrayList<>();
        perms.add(new ArrayList<>());

        for (int n : nums) {
            List<List<Integer>> new_perms = new ArrayList<>();
            for (List<Integer> p : perms) {
                for (int i = 0; i <= p.size(); i++) {
                    List<Integer> p_copy = new ArrayList<>(p);
                    p_copy.add(i, n);
                    new_perms.add(new ArrayList<>(p_copy));
                }
            }
            perms = new_perms;
        }

        return perms;
    }
}
