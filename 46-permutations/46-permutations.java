class Solution {
    public List<List<Integer>> permute(int[] a) {
        int n = a.length;
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean visit[] = new boolean[n];
        permutationNum(a, n, l, ds, visit);
        return l;
    }
    
    private void permutationNum(int a[], int n, List<List<Integer>> l, List<Integer> ds,
            boolean visit[]) {
        if (ds.size() == n) {
            l.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ds.add(a[i]);
                permutationNum(a, n, l, ds, visit);
                ds.remove(ds.size() - 1);
                visit[i] = false;
            }
        }
    }
}