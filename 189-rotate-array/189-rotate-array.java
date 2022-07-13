class Solution {

    public static void reverse(int a[], int i, int j) {
        while (i < j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }

    public static void rotate(int[] a, int k) {
        k = k % a.length;
        if (k < 0) {
            k = k + a.length;
        }
        reverse(a, 0, a.length - k - 1);
        reverse(a, a.length - k, a.length - 1);
        reverse(a, 0, a.length - 1);

    }
// for (int i=0;i<a.length;i++) {
//             System.out.println(a[i]);
//         }
}