class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int idx1=0;
        int idx2=0;
        int max=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]>max ||( prices[i]>min && idx1<idx2)){
                max=prices[i];
                idx1=i;
            }
            else if(prices[i]<min){
                min=prices[i];
                idx2=i;
            }
            if(idx1>idx2){
                profit=Math.max(profit,max-min);
            }
        }
        return profit;
    }
}

/*cleaner verson

class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                profit = Math.max(profit, prices[i] - min);
            }
        }
        return profit;
    }
}
*/