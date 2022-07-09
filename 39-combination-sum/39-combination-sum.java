class Solution {
    private static List<List<Integer>> sum(int index, int candidate[], int target, List<List<Integer>> ans, List<Integer> ds) {
        if (index == candidate.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
                return ans;
            }
        return new ArrayList<>();
        }
        if (target >= candidate[index]) {
            ds.add(candidate[index]);
            sum(index, candidate, target - candidate[index], ans, ds);
            ds.remove(ds.size() - 1);
        }
        sum(index + 1, candidate, target, ans, ds);
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
                List<List<Integer>> ans = new ArrayList<>();
                List<Integer> ds = new ArrayList<>();
                sum(0, candidates, target, ans, ds);
                return ans;
    }
}