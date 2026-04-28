class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefix_Map=new HashMap<>();
        prefix_Map.put(0,1);
        int count=0;
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int p=sum-k;
            if(prefix_Map.containsKey(p)){
                count+=prefix_Map.get(p);
            }
            prefix_Map.put(sum,prefix_Map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}