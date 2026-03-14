class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        if(n!=m) return -1;
        
        HashMap<Integer,Integer> allValues=new HashMap<>();
        HashMap<Integer,Integer> nums1_values=new HashMap<>();


        for(int val:nums1){
            allValues.put(val,allValues.getOrDefault(val,0)+1);
            nums1_values.put(val,nums1_values.getOrDefault(val,0)+1);
        }
        for(int val:nums2){
            allValues.put(val,allValues.getOrDefault(val,0)+1);
        }

        for(int v:allValues.values()){
            if(v%2==1) return -1; // means koi odd times present h tooo 2 arrays me equally nhi bant sakte
        }
        int cost=0;
        for(int key:allValues.keySet()){
            //target number of key must available in nums[1]
            int target=allValues.get(key)/2;

            // if nums1 have that value than return its count else give 0   
            int have=nums1_values.getOrDefault(key,0);

            if(have>target){
                cost+=have - target;
            }
        }
        return cost;
        
    }
}