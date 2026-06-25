class Solution {
    boolean[][] dp;
    int ans;
    public int countMajoritySubarrays(int[] nums, int target) {
        int[] prefix=new int[nums.length];
        if(nums[0]==target){
            prefix[0]=1;
        }
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1];
            if(nums[i]==target){
                prefix[i]++;
            }
        }
        ans=0;
        dp=new boolean[nums.length][nums.length];

        sol(0,0,nums,prefix);
        return ans;
    }
    public void sol(int i,int j,int[] nums,int[] prefix){
        if(j>=nums.length || i>j) return ;
        if(dp[i][j]) return;
        int len=j-i+1;
        int count=0;
        dp[i][j]=true;
        if(i==0){
            count=prefix[j];

        }
        else {
            count=prefix[j]-prefix[i-1];
        }
        if(count>len/2) ans++;
        // make all possible subarray
        sol(i,j+1,nums,prefix);
        sol(i+1,j,nums,prefix);

    }
}