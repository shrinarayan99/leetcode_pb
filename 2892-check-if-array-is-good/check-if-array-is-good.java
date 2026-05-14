class Solution {
    public boolean isGood(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int val:nums){
            max=Math.max(max,val);
        }
        if(max+1!=nums.length) return false;
        Arrays.sort(nums);
        for(int i=1;i<=max;i++){
            if(nums[i-1]!=i) return false;
        }
        if(nums[nums.length-1]!=max) return false;
        return true;
        
    }
}

/*

class Solution {
    public boolean isGood(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int val:nums){
            max=Math.max(max,val);
        }
        int[] base=new int[max+1];
        for(int i=1;i<=max;i++){
            base[i-1]=i;
        }
        base[max]=max;
        Arrays.sort(nums);
        if(base.length!=nums.length) return false;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=base[i]) return false;
        }
        return true;

    }
}

*/