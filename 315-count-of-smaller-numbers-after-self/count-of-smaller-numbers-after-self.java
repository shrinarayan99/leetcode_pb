class Solution {
    public List<Integer> countSmaller(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        int n=set.size();
        int[] sorted=new int[n];
        int z=0;
        for(int val:set){
            sorted[z]=val;
            z++;
        }
        Arrays.sort(sorted);
        int[] seg=new int[4*n];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(sorted[i],i);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=nums.length-1;i>=0;i--){
            int id=map.get(nums[i]);

            // query smaller elements
            int count = query(0, n - 1, 0, id - 1, 0, seg);

            ans.add(count);

            // update current element
            update(0, n - 1, 0, seg,id);
        }
        Collections.reverse(ans);
        return ans;
    }

    public static void update(int l,int r,int idx,int[] seg,int pos){
        if(l==r){
            seg[idx]+=1;
            return;
        }
        int mid=l+(r-l)/2;
        if(pos<=mid){
            update(l,mid,2*idx+1,seg,pos);
        }
        else{
            update(mid+1,r,2*idx+2,seg,pos);
        }
        seg[idx]=seg[2*idx+1]+seg[2*idx+2];
    }
    public static int query(int l,int r, int ql,int qr,int idx,int[] seg){
        if(qr<l || ql>r) return 0;
        if(qr>=r && ql<=l) return seg[idx];
        int mid=l+(r-l)/2;
        return query(l,mid,ql,qr,2*idx+1,seg)+query(mid+1,r,ql,qr,2*idx+2,seg);
    }
}


/*

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]>nums[j]) count++;
            }
            ans.add(count);
        }
        return ans;
    }
}


*/