class Solution {
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