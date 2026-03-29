class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int dif=-1;
        int one_idx=-1;
        int two_idx=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1) one_idx=i;
            else if(nums[i]==2) two_idx=i;
            if(one_idx!=-1 && two_idx!=-1){
                if(dif==-1){
                    dif=Math.abs(one_idx-two_idx);
                }
                else{
                    dif=Math.min(dif,Math.abs(one_idx-two_idx));
                }
            }

        }
        return dif;
    }
}