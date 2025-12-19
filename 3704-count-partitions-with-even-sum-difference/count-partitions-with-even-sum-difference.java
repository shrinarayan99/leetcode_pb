class Solution {
    public int countPartitions(int[] nums) {
        int rightSum=0;

        for(int val:nums){
            rightSum+=val;
        }

        return(sol(nums,0,0,rightSum,0));
    }

    public int sol(int[] nums,int i,int count,int rightSum,int leftSum){
        rightSum-=nums[i];
        leftSum+=nums[i];
        if(i==nums.length-1 || Math.abs(leftSum-rightSum)%2!=0){
            return count;
        }
        return sol(nums,i+1,count+1,rightSum,leftSum);
    }
}