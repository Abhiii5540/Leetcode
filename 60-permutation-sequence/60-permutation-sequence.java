class Solution {
    
    // APPROACH 1- 
        
     /*
     * The extreme naive solution is to generate all the possible permutations of
     * the given sequence. This is achieved using recursion and every permutation
     * generated is stored in some other data structure (here we have used a
     * vector). Finally, we sort the data structure in which we have stored all the
     * sequences and return the Kth sequence from it.
     */

    // static void swap(char s[], int i, int j) {
    // char ch = s[i];
    // s[i] = s[j];
    // s[j] = ch;
    // }

    // static void solve(char s[], int index, ArrayList<String> res) {
    // if (index == s.length) {
    // String str = new String(s);

    // res.add(str);
    // return;
    // }
    // for (int i = index; i < s.length; i++) {
    // swap(s, i, index);
    // solve(s, index + 1, res);
    // swap(s, i, index);
    // }
    // }

    // static String getPermutation(int n, int k) {
    // String s = "";
    // ArrayList<String> res = new ArrayList<>();
    // for (int i = 1; i <= n; i++) {
    // s += i;
    // }
    // solve(s.toCharArray(), 0, res);
    // Collections.sort(res);

    // return res.get(k);

    // }

    
    
        // APPROACH 2- 
    /*
     * Since this is a permutation we can assume that there are four positions that
     * need to be filled using the four numbers of the sequence. First, we need to
     * decide which number is to be placed at the first index. Once the number at
     * the first index is decided we have three more positions and three more
     * numbers. Now the problem is shorter. We can repeat the technique that was
     * used previously until all the positions are filled.
     */

    public String getPermutation(int n, int k) {
        List<Integer> l=new ArrayList<>();
        int f=1;
        for(int i=1;i<n;i++){
            f=f*i;
            l.add(i);
        }
        l.add(n);
        String ans="";
        k=k-1;
        while(true){
            ans=ans+l.get(k/f);
            l.remove(k/f);
            if(l.size()==0){
                break;
            }
            k=k%f;
            f=f/l.size();
        }
        return ans;
    }
}