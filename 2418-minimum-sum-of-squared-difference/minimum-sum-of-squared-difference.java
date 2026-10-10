class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        HashMap<Long,Long> map=new HashMap<>();
        long max=0;
        map.put(0L,0L);
        for(int i=0;i<n;i++){
            long dif=Math.abs((long)nums1[i]-nums2[i]);
            max=Math.max(max,dif);
            map.put(dif,map.getOrDefault(dif,0L)+1);
        }
        long totalOpr=(long)k1+k2;
        while(totalOpr > 0 && max > 0){
            long largest = map.getOrDefault(max, 0L);
            if(largest>=totalOpr){
                
                map.put(max,largest-totalOpr);
                 map.put(max-1,map.getOrDefault(max-1,0L)+totalOpr);
                 totalOpr=0;
            }
            else{
                map.put(max,0L);
                map.put(max-1,map.getOrDefault(max-1,0L)+largest);
                totalOpr-=largest;
            }
           max--;
        }

        long ans=0;
        for(Map.Entry<Long,Long> e:map.entrySet()){
            long key=e.getKey();
            long val=e.getValue();

            ans+=(key*key*val);
        }
        return ans;
        
    }
}

/*  BRUTE FORCE

        class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n=nums1.length;
        long[] dif=new long[n];
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<n;i++){
            dif[i]=Math.abs(nums1[i]-nums2[i]);
            pq.add(dif[i]);
        }
        long totalOpr=k1+k2;
        while(totalOpr>0){
            long curr=pq.poll();
            // no max value left and all values are 0
            if(curr==0) return 0;

            curr--;
            totalOpr--;
            pq.add(curr);

        }
        long ans=0;
        while(!pq.isEmpty()){
            long val=pq.poll();
            ans+=(val*val);
        }
        return ans;
    }
}

*/