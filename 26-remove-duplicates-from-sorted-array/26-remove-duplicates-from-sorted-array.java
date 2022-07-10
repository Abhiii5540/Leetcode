class Solution {
    public int removeDuplicates(int[] a) {
        int j=0;
        for (int i = 1; i < a.length; i++) {
            if(a[i]!=a[j]){
                j++;
                a[j]=a[i];
            }
        }
        // System.out.println(j+1);
        return j+1;
    }
}