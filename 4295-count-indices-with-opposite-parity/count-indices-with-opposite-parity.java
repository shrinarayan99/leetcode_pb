class Solution {
    public int[] countOppositeParity(int[] nums) {
        int even=0;
        int odd=0;
        for(int val:nums){
            if(val%2==0) even++;
            else odd++;
        }
        int n=nums.length;
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]%2==0){
                arr[i]=odd;
                even--;
            }
            else{
                arr[i]=even;
                odd--;
            }
        }
        return arr;
    }
}