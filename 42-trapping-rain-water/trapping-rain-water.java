class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftMax=new int[n];
        int l_max_value=-1;
        for(int i=0;i<n;i++){
            l_max_value=Math.max(l_max_value,height[i]);
            leftMax[i]=l_max_value;
        }

        int[] rightMax=new int[n];
        int r_max_val=-1;

        for(int i=n-1;i>=0;i--){
            r_max_val=Math.max(r_max_val,height[i]);
            rightMax[i]=r_max_val;
        }

        int water=0;
        for(int i=0;i<n;i++){
            water+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return water;
    }
}