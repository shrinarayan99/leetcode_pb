class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        long[] ans=new long[n];
       for(ArrayList<Integer> list:map.values()){
            int size=list.size();

            long[] prefix=new long[size];
            prefix[0]=list.get(0);
            for(int i=1;i<size;i++){
                prefix[i]=prefix[i-1]+list.get(i);
            }

            for(int i=0;i<size;i++){
                int idx=list.get(i);

                long left=0L;
                if(i>0){
                    left=(long)i*idx-prefix[i-1];
                }
                long right=0L;
                if(i<size-1){
                    right=(prefix[size-1]-prefix[i])-(long)(size-i-1)*idx;
                }

                ans[idx]=left+right;

            }
            
       }
       return ans;
    }
}

/*

        class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;

        HashMap<Integer,ArrayList<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
        long[] ans=new long[n];
        for(int i=0;i<n;i++){
            int val=0;
            for(int v:map.get(nums[i])){
                val+=Math.abs(i-v);
            }
            ans[i]=val;
        }
        return ans;
    }
}

*/