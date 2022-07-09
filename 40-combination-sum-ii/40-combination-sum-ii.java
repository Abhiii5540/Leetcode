class Solution {
    
     private void sum(int index, int candidate[], int target, List<List<Integer>> ans, List<Integer> ds) {

        if (target == 0) {
            ans.add(new ArrayList<>(ds));
            return ;
        }
        for (int i = index; i < candidate.length; i++) {
            if (i > index && candidate[i] == candidate[i - 1]) {
                continue;
            }
            if (target < candidate[i]) {
                break;
            }
            ds.add(candidate[i]);
            sum(i+ 1, candidate, target - candidate[i], ans, ds);
            ds.remove(ds.size() - 1);
        }
        // return ans;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        sum(0, candidates, target, ans, ds);
        return ans;
    }
}