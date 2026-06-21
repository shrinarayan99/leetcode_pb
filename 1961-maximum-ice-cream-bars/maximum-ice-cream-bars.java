class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;

        for(int price:costs){
            max=Math.max(max,price);
            min=Math.min(min,price);
        }

        int total_digit=max-min+1;

        int[] count=new int[total_digit+1];

        for(int price:costs){
            count[price-min+1]++;
        }

        int maxBuy=0;
        for(int i=0;i<=total_digit;i++){
            if(count[i]!=0 && coins>0){
                int canBuy=coins/(min+i-1);
                if(canBuy==0)break;
                if(canBuy>=count[i]){
                    maxBuy+=count[i];
                   coins -= count[i] * (min + i - 1);
                }
                else if(canBuy<count[i]){
                    maxBuy+=canBuy;
                    coins %= (min + i - 1);;
                }
                
            }
        }
        return maxBuy;
    }
}