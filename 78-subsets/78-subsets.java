class Solution {
    static void subsequence(int a[], int n, int i, ArrayList<Integer> l,List<List<Integer>> ans) {
        if (i == n) {
            ans.add(new ArrayList<>(l));
                return;
        } else {
            // take or pick the particular index into the subsequence
            subsequence(a, n, i + 1, l , ans);
            l.add(a[i]);
            // not pick,or not take condition,this elemnt is not added to your subsequence
            subsequence(a, n, i + 1, l , ans);
            l.remove(l.size() - 1);
        }
    }
    
    public List<List<Integer>> subsets(int[] a) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = a.length;
        ArrayList<Integer> l = new ArrayList<>();
        subsequence(a, n, 0, l ,ans);
        return ans;
    }
}