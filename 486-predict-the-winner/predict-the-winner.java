class Solution {
    public boolean predictTheWinner(int[] nums) {
        if(nums.length==1) return true;
        return selection(0,nums.length-1,0,0,nums,0);
    }

    public boolean selection(int i,int j,int score1 ,int score2,int[] nums,int flag){
        if(i>j)return score1>=score2;

        boolean fromStart=false;
        boolean fromEnd=false;
        if(flag==0){
            fromStart=selection(i+1,j,score1+nums[i],score2,nums,1);
            fromEnd=selection(i,j-1,score1+nums[j],score2,nums,1);
            return fromStart || fromEnd;
        }
        else{
            fromStart=selection(i+1,j,score1,score2+nums[i],nums,0);
            fromEnd=selection(i,j-1,score1,score2+nums[j],nums,0);
            return fromStart && fromEnd;
        }
        
    }
}