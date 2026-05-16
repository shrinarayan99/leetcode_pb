class Solution {
    public int findMin(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int val:nums){
            if(val<min){
                min=val;
            }
        }
        return min;
    }
}