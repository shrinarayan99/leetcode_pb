class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int val:nums){
            max=Math.max(max,val);
            min=Math.min(min,val);
        }

        return (long)(max-min)*k;
    }
}