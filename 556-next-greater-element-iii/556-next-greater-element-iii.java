class Solution {
    public int nextGreaterElement(int n) {
        String s = String.valueOf(n);
        char a[] = s.toCharArray();
        int i = a.length - 2;
        while (i >= 0 && a[i] >= a[i + 1]) {
            i--;
        }
        if (i == -1) {
            return -1;
        }
        int j = a.length - 1;
        while (a[j] <= a[i]) {
            j--;
        }
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;

        String r = "";
        for (int k = 0; k <= i; k++) {
            r += a[k];
        }
        for (int k = a.length - 1; k > i; k--) {
            r += a[k];
        }
        long ans = Long.parseLong(r);
        if(ans<=Integer.MAX_VALUE)
            return (int) ans;
        return -1;
    }
}