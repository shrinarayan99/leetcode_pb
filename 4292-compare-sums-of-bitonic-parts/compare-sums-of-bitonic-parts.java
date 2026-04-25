class Solution {
    public int compareBitonicSums(int[] nums) {
        long[] prefix=new long[nums.length];
        prefix[0]=nums[0];
        int maxIdx=0;
        for(int i=1;i<nums.length;i++){
            prefix[i]=prefix[i-1]+nums[i];

            if(nums[maxIdx]<nums[i]){
                maxIdx=i;
            }
        }

        if(prefix[maxIdx-1]>prefix[nums.length-1]-prefix[maxIdx]){
            return 0;
        }
        if(prefix[maxIdx-1]<prefix[nums.length-1]-prefix[maxIdx]) return 1;
        return -1;

    }
}