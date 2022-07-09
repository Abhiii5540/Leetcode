class Solution {
    
    private void subset(int index, int a[], List<List<Integer>> ans, List<Integer> ds) {
        ans.add(new ArrayList<>(ds));
        for (int i = index; i < a.length; i++) {
            if (i > index && a[i] == a[i - 1]) {
                continue;
            }
            ds.add(a[i]);
            subset(i + 1, a, ans, ds);
            ds.remove(ds.size() - 1);
        }

    }
    
    public List<List<Integer>> subsetsWithDup(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        Arrays.sort(a);
        subset(0, a, ans, ds);
        return ans;
    }
}