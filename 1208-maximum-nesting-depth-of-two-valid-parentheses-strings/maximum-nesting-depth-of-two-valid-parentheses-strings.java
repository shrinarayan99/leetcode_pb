class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        Stack<Character> g0=new Stack<>();
        Stack<Character> g1=new Stack<>();

        int[] ans=new int[seq.length()];
        int grp=0;

        for(int i=0;i<seq.length();i++){
            if(seq.charAt(i)=='('){
                if(grp==0){
                    g0.push('(');
                    ans[i]=grp;
                    grp=1;
                }
                else{
                    g1.push('(');
                    ans[i]=grp;
                    grp=0;
                }
            }
            else{
                if(grp==0 && !g1.isEmpty()){
                    g1.pop();
                    ans[i]=1;
                    grp=1;
                }
                else if(grp==1 && !g0.isEmpty()){
                    g0.pop();
                    ans[i]=0;
                    grp=0;
                }
            }
        }
        return ans;
    }
}