class Solution {
    public int firstUniqueEven(int[] nums) {
        int[] count=new int[101];

        for(int val:nums){
            count[val]++;
        }

        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0 && count[nums[i]]==1){
                return nums[i];
            }
        }
        return -1;
    }
}