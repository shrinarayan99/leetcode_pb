class Solution {
    public int minMoves(int[] nums) {
        int max=0;
        for(int val:nums){
            max=Math.max(max,val);
        }
        int ans=0;
        for(int val:nums){
            ans+=(max-val);
        }
        return ans;
    }
}