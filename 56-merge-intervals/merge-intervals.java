class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        ArrayList<int[]> list=new ArrayList<>();
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=0;i<intervals.length;i++){
            int st=intervals[i][0];
            int ed=intervals[i][1];
            if(st>end){
                list.add(new int[] {start,end});
                start=st;
                end=ed;
            }
            else end=Math.max(ed,end);
            
        }
        list.add(new int[] {start,end});

        int[][] ans=new int[list.size()][2];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}