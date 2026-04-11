class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer,ArrayList<Integer> > map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }

        int ans=Integer.MAX_VALUE;

        for(Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()){
             ArrayList<Integer> value = entry.getValue();

             if(value.size()>=3){
                int i=0;
                int j=2;

                while(j<value.size()){
                    int v=(Math.abs(value.get(i) - value.get(i+1)) + Math.abs(value.get(i+1) - value.get(i+2)) + Math.abs   (value.get(i+2) - value.get(i)));

                    ans=Math.min(ans,v);

                    i++;

                    j++;
                }
             }

        }
        if(ans==Integer.MAX_VALUE) return -1;
        return ans;
    }
}