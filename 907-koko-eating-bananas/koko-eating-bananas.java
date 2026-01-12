//https://www.youtube.com/watch?v=qyfekrNni90

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max=0;// will store how max banana koko can eat to finish in min hours
        // but we have to find min banana that koko can eat per Hour to finish all banana in h hours
        for(int val:piles){
            max=Math.max(max,val);
        }
        int left=1;
        int right=max;
        int ans=Integer.MAX_VALUE;
        while(left<=right){
            int mid=left+(right-left)/2;
            long willTake=sol(piles,mid);
            if(willTake>h){
                left=mid+1;
            }
            else if(willTake<=h){
                ans=mid;
                right=mid-1;
            }
        }
        return ans;
    }
    public long sol(int[] arr, int bananaPerHour){
        long requireHours=0;
        for(int i=0;i<arr.length;i++){
            requireHours+=arr[i]/bananaPerHour;
            if(arr[i]%bananaPerHour!=0){
                requireHours+=1;
            }
        }
        return requireHours;
    }
}