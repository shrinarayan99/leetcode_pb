class Solution {
    public int search(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        if(nums[start]==target && nums.length==1){return start;}
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
           // checking soted array(jis side sort hoga pahle usme check krenge ki hai ya nhi)
           //Left array me check krenge(on the basis on mid)
           if(nums[mid]<=nums[end]){
                if(nums[mid]<target && nums[end]>=target){
                    start=mid+1;
                }
                else{
                    end=mid-1;
                }
           }
           // agr left sorted array me n mile to right me check kr lo
           else{
                if(nums[start]<=target && nums[mid]>target){
                    end=mid-1;
                }
                else{
                    start=mid+1;
                }
           }
        }
        return -1;    
    }
    
}

/*  CORRECT BUT HAS MORE TC {O(n)}
  
   class Solution {
    public int search(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            if(nums[i]==target){
                return i;
            }
        }
        return -1;
    }
}


// TWO POINTER METHOD

    int start=0;
        int end=nums.length-1;
        while(start<=end){
            if(nums[start]==target){
                return start;
            }
            else if(nums[end]==target){
                return end;
            }
            else{
                end--;
                start++;
            }
        }
        return -1;

*/