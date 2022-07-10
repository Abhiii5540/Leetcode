class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int surplus=0;
        int deficit=0;
        int startingPoint=0;
        for (int i = 0; i < gas.length; i++) {
            surplus+=gas[i]-cost[i];
                deficit+=gas[i]-cost[i];
            if(surplus<0){
                surplus=0;
                startingPoint=i+1;
            }
        }
        return(deficit<0)?-1:startingPoint;
    }
}