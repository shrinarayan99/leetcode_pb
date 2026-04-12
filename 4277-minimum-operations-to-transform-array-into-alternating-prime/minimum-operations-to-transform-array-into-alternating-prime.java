class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            if(i%2==0){
                if(isPrime(n)) continue;
                
                while(!isPrime(n)){
                    ans++;
                    n++;
                }
            }
            else{
                if(!isPrime(n)) continue;
                
                while(isPrime(n)){
                    ans++;
                    n++;
                }
            }
            
        }
        return ans;
    }
    public boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;

        if(n%2==0) return false;

        for(int i=3;i*i<=n;i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
}