class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int less=0;
        int same=0;
        int bigger=0;

        for(int val:nums){
            if(val<pivot) less++;
            else if(val>pivot) bigger++;
            else same++;
        }
        int[] ans=new int[nums.length];

        int left=0;
        int mid=less;
        int right=less+same;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<pivot){
                ans[left]=nums[i];
                left++;
            }
            else if(nums[i]>pivot){
                ans[right]=nums[i];
                right++;
            }
            else{
                ans[mid]=nums[i];
                mid++;
            }
        }
        return ans;
    }
}