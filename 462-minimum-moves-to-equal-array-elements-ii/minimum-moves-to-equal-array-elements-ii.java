class Solution {
    public int minMoves2(int[] nums) {
        int n =nums.length;
        Arrays.sort(nums);
        int mid=n/2;
        int avg=nums[mid];
       
        int count=0;
        for(int val:nums){
            count+=(Math.abs(val-avg));
        }
        return count;
    }
}