class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int[] left_Max=new int[n];
        left_Max[0]=nums[0];
        for(int i=1;i<n;i++){
            left_Max[i]=Math.max(nums[i],left_Max[i-1]);
        }
        int[] right_min=new int[n];
        right_min[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right_min[i]=Math.min(right_min[i+1],nums[i]);
            // if(nums[i]<nums[right_minIndex[i+1]]){
            //     if(left_Max[i]>left_Max[right_minIndex[i+1]]){
            //         right_minIndex[i]=i;
            //     }
            //     else{
            //         right_minIndex[i]=right_minIndex[i+1];
            //     }
                
            // }
            // else{
            //     right_minIndex[i]=right_minIndex[i+1];
            // }
        }
        int[] ans = new int[n];
        ans[n-1]=left_Max[n-1];
        for(int i=n-2;i>=0;i--){
            // ans[i]=left_Max[right_minIndex[i]];
            if(left_Max[i]<=right_min[i+1]){
                ans[i]=left_Max[i];
            }
            else if(left_Max[i]>right_min[i+1]){
                ans[i]=ans[i+1];
            }
        }
        
        return ans;
    }
    
}

/*
class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int[] left_Max=new int[n];
        left_Max[0]=nums[0];
        for(int i=1;i<n;i++){
            left_Max[i]=Math.max(nums[i],left_Max[i-1]);
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[j]<nums[i] || nums[j]<left_Max[i]){
                    left_Max[i]=Math.max(nums[j],left_Max[j]);
                }
            }
        }
        return left_Max;
    }
}

*/