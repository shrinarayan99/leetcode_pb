class Solution {
    String s;
    int n;
    long[][][] dp1;//total numbers;
    long[][][] dp2;//total waviness
    public long totalWaviness(long num1, long num2) {
        return func(num2)-func(num1-1);
    }


    public long func(long num){
        if(num<100) return 0;
        s=String.valueOf(num);
        n=s.length();
        dp1=new long[16][10][10];
        dp2=new long[16][10][10];
        for(int i=0;i<16;i++){
            for(int j=0;j<10;j++){
                for(int k=0;k<10;k++){
                    dp1[i][j][k]=-1;
                    dp2[i][j][k]=-1;
                }
            }
        }
        long[] ans=sol(0,-1,-1,true,true);
        //ans[]=new int[totalNumbers , totalWaveScore]
        return ans[1];
    }


    public long[] sol(int current,int prev,int prevPrev,boolean isLeadingZero,boolean isLimitedWithActualNumber){

        if(current==n) return new long[] {1,0};// no scoee can be generated and we found one last number
        if(!isLeadingZero && !isLimitedWithActualNumber && prev!=-1 && prevPrev!=-1){
            if(dp1[current][prev][prevPrev]!=-1 && dp2[current][prev][prevPrev]!=-1 ){
                return new long[]{ dp1[current][prev][prevPrev],dp2[current][prev][prevPrev]};
            }
        }

        int limit=isLimitedWithActualNumber?s.charAt(current)-'0':9;

        long totalWaveNumbers=0;
        long totalWavynessScore=0;

         for(int digit=0;digit<=limit;digit++){
           boolean newLeadingZero=(isLeadingZero && digit==0);
           int newPrevPrev=prev;
           int newPrev=(newLeadingZero)?-1:digit;

           long[] res=sol(current+1,newPrev,newPrevPrev,newLeadingZero,(isLimitedWithActualNumber && digit==limit));


           if(!newLeadingZero && prev>=0 && prevPrev>=0){
                if((prev>digit && prev>prevPrev) || (prev<digit && prev<prevPrev)){
                    //res[0]=remainingTotalNumbers(same prefix se kitne number or ban saktee h to unke liye prefix k count same rhega)
                    totalWavynessScore+=res[0];
                }    
           }
           //res[1]=remaining totalWaveScore
           totalWaveNumbers+=res[0];
           totalWavynessScore+=res[1];

         }
         if(!isLeadingZero && !isLimitedWithActualNumber && prev!=-1 && prevPrev!=-1){
            
                dp1[current][prev][prevPrev]=totalWaveNumbers;
                dp2[current][prev][prevPrev]=totalWavynessScore;
            
        }
        return new long[] {totalWaveNumbers,totalWavynessScore};
    }
}