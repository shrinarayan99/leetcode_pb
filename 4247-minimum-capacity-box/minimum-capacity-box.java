class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int ans=-1;
        int remain=Integer.MAX_VALUE;

        for(int i=0;i<capacity.length;i++){
            if(capacity[i]>=itemSize){
                int dif=capacity[i]-itemSize;
                if(dif<remain){
                    ans=i;
                    remain=dif;
                }
                
            }
        }
        return ans;
    }
}