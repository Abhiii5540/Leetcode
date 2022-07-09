class Solution {
    public List<List<Integer>> permute(int[] a) {
        int n = a.length;
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean visit[] = new boolean[n];
        permutationNum(a, n, l, ds, visit);
        return l;
    }
        // taking a extra space for a list and array for visiting n not visiting

    private void permutationNum(int a[], int n, List<List<Integer>> l, List<Integer> ds,
            boolean visit[]) {
        if (ds.size() == n) {
            l.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                // if not marked then ,add in the list and mark it true
                visit[i] = true;
                ds.add(a[i]);
                permutationNum(a, n, l, ds, visit);
             // now for next recursive call , remove the element and make it false
                ds.remove(ds.size() - 1);
                visit[i] = false;
            }
        }
    }
}



 // nowdoing it without taking a ds list n a vistied bollean array
    // can be done by swapping with each element
    static List<List<Integer>> permutationNum2(int a[], int n, List<List<Integer>> l, int index) {
        if (index == n) {
            List<Integer> ds = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                ds.add(a[j]);
            }
            l.add(new ArrayList<>(ds));
            return l;
        }
        for (int j = index; j < n; j++) {
            swap(a, j, index);
            permutationNum2(a, n, l, index + 1);
            swap(a, j, index);
        }
        return l;
    }

    private static void swap(int a[], int index, int j) {
        int t = a[index];
        a[index] = a[j];
        a[j] = t;
    }
