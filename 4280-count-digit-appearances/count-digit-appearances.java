class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            String numStr = String.valueOf(nums[i]); 
            for(char val:numStr.toCharArray()){
                if(val-'0'==digit) ans++;
            }
        }
        return ans;
    }
}