class Solution {
    // public int[] leftMax;
    // public int[] rightMax;
    public int maxJumps(int[] arr, int d) {
        // leftMax=new int[arr.length];
        // leftMax[0]=arr[0];
        // for(int i=1;i<arr.length;i++){
        //     leftMax[i]=Math.max(leftMax[i-1],arr[i]);
        // }
        // rightMax=new int[arr.length];
        // rightMax[arr.length-1]=arr[arr.length-1];
        // for(int i=arr.length-1;i>=0;i--){
        //     rightMax[i]=Math.max(rightMax[i+1],arr[i]);
        // }
        int[] dp=new int[arr.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        for(int i=0;i<arr.length;i++){
            if(dp[i]==Integer.MAX_VALUE){
                dp[i]=sol(i,arr,d,dp);
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int val:dp){
            ans=Math.max(ans,val);
        }
        return ans;

        
    }
    public int sol(int i,int[] arr,int d,int[] dp){
        if(i<0 || i>=arr.length) return 0;
        if(dp[i]!=Integer.MAX_VALUE) return dp[i];
        boolean canJump_right=true;
        boolean canJump_left=true;
        int right=1;
        int left=1;
        for(int j=1;j<=d;j++){
            
            if(i+j<arr.length ){
                if(arr[i]>arr[i+j] && canJump_right){
                    right=Math.max(right,1+sol(i+j,arr,d,dp));
                }
                else if(arr[i]<=arr[i+j]){
                    canJump_right=false;
                }
                
            }
            if(i-j>=0 ){
                if(arr[i]>arr[i-j] && canJump_left){
                    left=Math.max(left,1+sol(i-j,arr,d,dp));
                }
                else if(arr[i]<=arr[i-j]){
                    canJump_left=false;
                }
            }
        }
        return dp[i]=Math.max(left,right);
    }
}