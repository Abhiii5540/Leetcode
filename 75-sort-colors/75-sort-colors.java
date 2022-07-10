class Solution {
    static void swap(int a[], int i, int j) {

        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public void sortColors(int[] a) {
         
        int low = 0;
        int high = a.length - 1;
        int mid = 0;
        while (mid <= high) {
            switch (a[mid]) {
                case 0:
                    swap(a, low, mid);

                    low++;
                    mid++;
                    break;

                case 1:
                    mid++;
                    break;

                case 2:
                    swap(a, mid, high);

                    high--;
                    break;
            }
        }
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    }