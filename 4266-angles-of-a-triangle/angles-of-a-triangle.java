class Solution {
    public double[] internalAngles(int[] sides) {
        /*

        double sum=0;
        for(int val:sides){
            sum+=val;
        }
        double s=sum/2.0;

        //double area=Math.sqrt(s*(s-sides[0])*(s-sides[1])*(s-sides[2]));
        
           //     s*(s-sides[0])*(s-sides[1])*(s-sides[2])   {this can be negative so area will be wrong}
        

        double area=s*(s-sides[0])*(s-sides[1])*(s-sides[2]);
       
        if(area<0) return new double[3];

        */

        if (sides[0] + sides[1] <= sides[2] ||sides[1] + sides[2] <= sides[0] ||sides[0] + sides[2] <= sides[1]) {
            return new double[]{};
        }

         double[] ans=new double[3];
        // opposite to first sides[0];
        ans[0]=calculate(sides[1],sides[2],sides[0]);
        // opposite to first sides[1];
        ans[1]=calculate(sides[0],sides[2],sides[1]);
        // opposite to first sides[2];
        ans[2]=calculate(sides[0],sides[1],sides[2]);
        Arrays.sort(ans);
        return ans;


    }
    public double calculate(int a,int b,int c){
        double cosC=(Math.pow(a,2)+Math.pow(b,2)-Math.pow(c,2))/(2*a*b);

        //cosC--> NaN

         cosC = Math.max(-1.0, Math.min(1.0, cosC));

        double radian=Math.acos(cosC);

        return Math.toDegrees(radian);
    }
}