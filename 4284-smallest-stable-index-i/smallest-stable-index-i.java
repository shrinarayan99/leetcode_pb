class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] min=new int[nums.length];
        min[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            min[i]=Math.min(nums[i],min[i+1]);
        }
        int max=nums[0];

        for(int i=0;i<nums.length;i++){
            int stability_score=max-min[i];
            if(stability_score<=k) return i;
            max=Math.max(max,nums[i]);
        }
        return -1;
    }
}