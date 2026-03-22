class NumArray {
    int n;
    int[] seg;
    public NumArray(int[] nums) {
        n=nums.length;
        seg=new int[4*n];
        build(0,0,n-1,nums,seg);
    }
    
    public void update(int index, int val) {
        up(0,0,n-1,seg,index,val);
    }
    
    public int sumRange(int left, int right) {
        return sum(0,left,right,0,n-1,seg);
    }
    public static void build(int idx,int l,int r, int[] nums,int[] seg){
        if(l==r){
            seg[idx]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;
        build(2*idx+1,l,mid,nums,seg);
        build(2*idx+2,mid+1,r,nums,seg);

        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public static void up(int idx,int l,int r, int[] seg,int point,int val){
        if(l==r){
            seg[idx]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(point<=mid){
            up(2*idx+1,l,mid,seg,point,val);
        }
        else{
            up(2*idx+2,mid+1,r,seg,point,val);
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public static int sum(int idx,int ql,int qr,int l,int r, int[] seg){
        if(l>qr || r<ql) return 0;
        if(ql<=l && r<=qr) return seg[idx];
        int mid=l+(r-l)/2;
        int left=sum(2*idx+1,ql,qr,l,mid,seg);
        int right=sum(2*idx+2,ql,qr,mid+1,r,seg);
        return left+right;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */