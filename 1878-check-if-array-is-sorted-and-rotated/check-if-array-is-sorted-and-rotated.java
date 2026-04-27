class Solution {
    public boolean check(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%nums.length]){
                count++;
            }
        }
        return count<=1;
    }
}

/*

                class Solution {
    public boolean check(int[] nums) {
        int minIdx=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[minIdx]){
                minIdx=i;
            }
        }
        int[] arr=Arrays.copyOf(nums,nums.length);
        Arrays.sort(arr);

        for(int i=0;i<nums.length;i++){
            if(nums[(minIdx+i)%nums.length]!=arr[i]) return false;
        }
        return true;
    }
}

*/