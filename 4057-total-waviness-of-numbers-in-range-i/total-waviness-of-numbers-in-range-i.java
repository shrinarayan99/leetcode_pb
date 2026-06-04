class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        int start=Math.max(num1,100);
        for(int i=start;i<=num2;i++){
            ans+=helper(i);
        }
        return ans;
    }
    public int helper(int n){
        int count=0;

        int last=n%10;
        n/=10;
        int curr=n%10;
        n/=10;
        while(n>0){
            int next=n%10;

            if((curr>last && curr>next)||(curr<last && curr<next)) count++;

            last=curr;
            curr=next;
            n/=10;
        }
        return count;
    }
}