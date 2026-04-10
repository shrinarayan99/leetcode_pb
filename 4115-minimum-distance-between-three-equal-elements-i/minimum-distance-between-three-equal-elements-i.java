class Solution {
    public int minimumDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        int n=nums.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[i]==nums[j] && nums[j]==nums[k]){
                        int val=Math.abs(i-j)+Math.abs(j-k)+Math.abs(k-i);
                        ans=Math.min(ans,val);
                    }
                }
            }
        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}