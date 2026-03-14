class Solution {
    public long gcdSum(int[] nums) {
        int max=0;
        int[] prefixGcd=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            prefixGcd[i]=GCD(nums[i],max);
        }

        Arrays.sort(prefixGcd);
        long ans=0;

        int left=0;
        int right=nums.length-1;
        while(right>left){
            ans+=GCD(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return ans;
    }


    public int GCD(int a, int b){
        if(b==0) return a;
        return GCD(b,a%b);
    }

    
}