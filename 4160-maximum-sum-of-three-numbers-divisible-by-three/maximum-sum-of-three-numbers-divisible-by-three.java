class Solution {
    public int maximumSum(int[] nums) {
        int [] arr=nums;
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        List<Integer> l3=new ArrayList<>();
        for(int x:arr){
            if(x%3==0) l1.add(x);
            else if(x%3==1) l2.add(x);
            else l3.add(x);
        }

        Collections.sort(l1,Collections.reverseOrder());
        Collections.sort(l2,Collections.reverseOrder());
        Collections.sort(l3,Collections.reverseOrder());
        int ans=0;
        if(l1.size()>=3){
            ans=Math.max(ans,l1.get(0)+l1.get(1)+l1.get(2));
        }
        if(l2.size()>=3){
            ans=Math.max(ans,l2.get(0)+l2.get(1)+l2.get(2));
        }
        if(l3.size()>=3){
            ans=Math.max(ans,l3.get(0)+l3.get(1)+l3.get(2));
        }

        if(l1.size()>=1 && l2.size()>=1 && l3.size()>=1){
            ans=Math.max(ans,l1.get(0)+l2.get(0)+l3.get(0));
        }
        return ans;
    }
}

/* will face tle
class Solution {
    public int maximumSum(int[] nums) {
       int sum=0;
        
        for(int val:nums){
            sum+=val;
        }
        if(sum%3==0) return sum;
       
        return sol(nums,0,0,0);
        
    
        
    }
    public int sol(int[] nums,int i,int sum,int count){
        
        if(count==3) {
            if(sum%3==0){
                //count=0;
                return sum;
            }
            return Integer.MIN_VALUE;
        }
        if(i==nums.length ) return Integer.MIN_VALUE;
        
        //if(dp[i][sum]!=Integer.MIN_VALUE) return dp[i][sum];
        int take=sol(nums,i+1,sum+nums[i],count+1);
        int skip=sol(nums,i+1,sum,count);

        return Math.max(take,skip);
    }
}

*/