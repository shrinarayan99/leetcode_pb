class Solution {
    public int uniqueXorTriplets(int[] nums) {
        if(nums.length==1 || nums.length==2)return nums.length;

        int val=2;
        // nearest grater 2 ki power vali value hi ans hoga
        while(val<=nums.length){
            val*=2;
        }
        return val;
    }
}