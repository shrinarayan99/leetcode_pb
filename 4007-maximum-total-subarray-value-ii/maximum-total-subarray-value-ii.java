class Solution {
    int[] seg_min;
    int[] seg_max;
    public long maxTotalValue(int[] nums, int k) {
        int n=nums.length;

        seg_min=new int[4*n];
        seg_max=new int[4*n];
        segment_min(0,0,n-1,nums);
        segment_max(0,0,n-1,nums);

        PriorityQueue<int[]> q=new PriorityQueue<>((a,b)->(b[0]-a[0]));
        long ans=0;
        for(int i=0;i<n;i++){
            int max=find_max(0,i,n-1,0,n-1);
            int min=find_min(0,i,n-1,0,n-1);

            q.add(new int[] {max-min,i,n-1});
        }
        while(k>0){
            int[]curr=q.poll();
            ans+=curr[0];
            int max=find_max(0,curr[1],curr[2]-1,0,n-1);
            int min=find_min(0,curr[1],curr[2]-1,0,n-1);
            if(curr[1]<curr[2]){
                q.add(new int[] {max-min,curr[1],curr[2]-1});
            }
            k--;
        }
       
        return ans;
    }
    public void segment_min(int idx,int l,int r,int[] nums){
        if(l==r){
            seg_min[idx]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;

        segment_min(2*idx+1,l,mid,nums);
        segment_min(2*idx+2,mid+1,r,nums);

        seg_min[idx]=Math.min(seg_min[2*idx+1],seg_min[2*idx+2]);
    }
    public void segment_max(int idx,int l,int r,int[] nums){
        if(l==r){
            seg_max[idx]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;

        segment_max(2*idx+1,l,mid,nums);
        segment_max(2*idx+2,mid+1,r,nums);

        seg_max[idx]=Math.max(seg_max[2*idx+1],seg_max[2*idx+2]);
    }
    public int  find_min(int idx, int nl,int nr,int l,int r){
        if(nl>r || nr<l) return Integer.MAX_VALUE;

        if(l>=nl && r<=nr) return seg_min[idx];

        //if(l==r) return seg_min[idx];

        int mid=l+(r-l)/2;

        int left=find_min(2*idx+1,nl,nr,l,mid);
        int right=find_min(2*idx+2,nl,nr,mid+1,r);

        return Math.min(left,right);
    }
    public int  find_max(int idx, int nl,int nr,int l,int r){
        if(nl>r || nr<l) return Integer.MIN_VALUE;

        if(l>=nl && r<=nr) return seg_max[idx];
        //if(l==r) return seg_max[idx];
        int mid=l+(r-l)/2;

        int left=find_max(2*idx+1,nl,nr,l,mid);
        int right=find_max(2*idx+2,nl,nr,mid+1,r);

        return Math.max(left,right);
    }
}