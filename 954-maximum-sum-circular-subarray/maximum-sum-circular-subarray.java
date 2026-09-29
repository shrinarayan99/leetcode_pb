//total subarray_sum - min_sumSubArray=Max circular sum sub array

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum=0;
        for(int val:nums){
            totalSum+=val;
        }


        //finding minimum sum of array        
        int minSum=Integer.MAX_VALUE;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=Math.min(sum+nums[i],nums[i]);
            minSum=Math.min(sum,minSum);
            
        }

        //circular max sum
        int max_circularSum_subArray=totalSum-minSum;

        //linear array max sum
        int maxSum_subArray=Integer.MIN_VALUE;
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum=Math.max(sum+nums[i],nums[i]);
            maxSum_subArray=Math.max(sum,maxSum_subArray);    
        }

        //if all elements are 0
        if(maxSum_subArray<0)return maxSum_subArray;

        //return weather we are finding max sum circulary or linearly
        return Math.max(maxSum_subArray,max_circularSum_subArray);
    }
}