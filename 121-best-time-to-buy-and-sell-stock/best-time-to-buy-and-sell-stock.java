class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;

        //always sell in right when but
        int[] max=new int[n];
        max[n-1]=prices[n-1];

        // // always buy in left
        // int[] min=new int[n];
        // min[0]=prices[0];

        // for(int i=1;i<n;i++){
        //     min[i]=Math.min(min[i-1],prices[i]);
        // }
        for(int i=n-2;i>=0;i--){
            max[i]=Math.max(max[i+1],prices[i]);
        }

        int result=0;
        // for(int i=0;i<n;i++){
        //     result=Math.max(result,max[i]-min[i]);
        // }

        //check for everyday buy but sell on right max day
        for(int i=0;i<n;i++){
            result=Math.max(result,max[i]-prices[i]);
        }
        return result;
    }
}