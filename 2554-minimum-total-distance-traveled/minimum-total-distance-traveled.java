class Solution {
    public Long[][] dp;
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        //robot and factory arranged to closer to each other
        Collections.sort(robot);
        Arrays.sort(factory,(a,b)->a[0]-b[0]);


        // will manage the limit of factory

        /*
            eg:-  [2,3]-->{2,2,2} // let we have 3 time 2 factories
        */
        ArrayList<Integer> list=new ArrayList<>();
        for(int[] val:factory){
            for(int i=0;i<val[1];i++){
                list.add(val[0]);
            }
        }
        dp=new Long[robot.size()][list.size()];
        return sol(0,0,robot,list);
    }

    public long sol(int i,int j,List<Integer> robot ,ArrayList<Integer> list){
        // if we repair all robots
        if(i>=robot.size() ) return 0;

        // if we use all factoris but robot remains
        if(j>=list.size() ) return Long.MAX_VALUE;

        if(dp[i][j]!=null) return dp[i][j];

        // weather use current factoey or not

        long next=sol(i+1,j+1,robot,list);

        long take=Long.MAX_VALUE;
        if(next!=Long.MAX_VALUE){
            take=Math.abs(robot.get(i)-list.get(j))+next;
        }

         
        long skip=sol(i,j+1,robot,list);

        return dp[i][j]=Math.min(take,skip);
    }
}