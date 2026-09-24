class Solution {
    public int smallestIndex(int[] nums) {
        for(int i=0;i<nums.length;i++){
            // if(i<=9 && i==nums[i]) return i;
            // else if(nums[i]>9){
            //     int sum=totalSum(nums[i]);
            //     if(sum==i)return i;
            // }
            int sum=totalSum(nums[i]);
                if(sum==i)return i;
        }
        return -1;
    }
    public int totalSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}