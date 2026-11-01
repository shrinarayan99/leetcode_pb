// ulta socho ki max ko min tk le jana hai {kyuki usme sirf ik value handle krni padegi}
// to total steps honge ki har value ko min tk le jane me kitne steps lagenge
class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int min=Integer.MAX_VALUE;
        for(int val:nums){
            sum+=val;
            min=Math.min(min,val);
        }
        return sum-(nums.length*min);
    }
}