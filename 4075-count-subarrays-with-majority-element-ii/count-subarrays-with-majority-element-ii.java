//https://www.youtube.com/watch?v=d8gBjEG6Ouc

class Solution {
    public long countMajoritySubarrays(int[] nums, int target) {

        HashMap<Long,Long> map=new HashMap<>();
        map.put(0L,1L);
        long cumelativeSum=0;
        long result=0L;
        long validpoints=0L;
        for(int i=0;i<nums.length;i++){
            
            if(nums[i]==target){
                validpoints+=map.get(cumelativeSum);
                cumelativeSum++;
            }
            else{
                cumelativeSum--;
                validpoints-=map.getOrDefault(cumelativeSum,0L);
            }
            map.put(cumelativeSum,map.getOrDefault(cumelativeSum,0L)+1);

            result+=validpoints;
        }
        return result;
    }
}