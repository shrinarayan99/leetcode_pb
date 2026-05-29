class Solution {
    public int minElement(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int val:nums){
            if(val>=0 && val<=9){
                min=Math.min(min,val);
            }
            else{
                int sum=0;
                while(val>0){
                    int rem=val%10;
                    sum+=rem;
                    val/=10;
                }
                min=Math.min(min,sum);
            }
        }
        return min;
    }
}