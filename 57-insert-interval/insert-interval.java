class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;
        if(n == 0) {
            return new int[][] {
                {newInterval[0], newInterval[1]}
            };
        }
        ArrayList<int[]> merge_list=new ArrayList<>();
        boolean flag=false;
        for(int i=0;i<n;i++){
            if(intervals[i][0]>newInterval[0] && !flag){
                 merge_list.add(new int[]{newInterval[0],newInterval[1]});
                 flag=true;
            }
            merge_list.add(intervals[i]);
        }
        if(!flag){
            merge_list.add(new int[]{newInterval[0],newInterval[1]});
        }

        ArrayList<int[]> list=new ArrayList<>();

        int start=merge_list.get(0)[0];
        int end=merge_list.get(0)[1];
        for(int i=0;i<=n;i++){
            if(end<merge_list.get(i)[0]){
                list.add(new int[] {start,end});
                start=merge_list.get(i)[0];
                end=merge_list.get(i)[1];
            }
            else end=Math.max(end,merge_list.get(i)[1]);
        }
        list.add(new int[] {start,end});
        int size=list.size();
        int[][] ans=new int[size][2];
        for(int i=0;i<size;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}








/*


class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n=intervals.length;

        int[][] inter=new int[n+1][2];

        for(int i=0;i<n;i++){
            inter[i]=intervals[i];
        }
        inter[n]=newInterval;

        Arrays.sort(inter,(a,b)->a[0]-b[0]);

        ArrayList<int[]> list=new ArrayList<>();

        int start=inter[0][0];
        int end=inter[0][1];
        for(int i=0;i<=n;i++){
            if(end<inter[i][0]){
                list.add(new int[] {start,end});
                start=inter[i][0];
                end=inter[i][1];
            }
            else end=Math.max(end,inter[i][1]);
        }
        list.add(new int[] {start,end});
        int size=list.size();
        int[][] ans=new int[size][2];
        for(int i=0;i<size;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }
}


*/
