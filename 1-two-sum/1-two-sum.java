class Solution {
    public int[] twoSum(int[] a, int t) {
        int ans[]=new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            int key = t - a[i];
            if (map.get(a[i]) == null) {
                map.put(key, i);
            } else {
                // System.out.println("Sum found at " + i + " and "+map.get(a[i]));
                ans[0]=map.get(a[i]);
                ans[1]=i;
            }
    }
        return ans;
}
}