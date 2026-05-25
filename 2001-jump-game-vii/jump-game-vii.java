class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int farthest=0;
    
        while(!q.isEmpty()){
            int idx=q.poll();
            farthest=Math.max(farthest+1,idx+minJump);
            //will skip already visited;\
            //kyuki agar queue se jaenge to min and max ke beech already visited ko bar baar check krna pdega to tle aa jaega
            for(int i=farthest;i<=Math.min(idx+maxJump,s.length()-1);i++){
                if(s.charAt(i)=='0'){
                    if(i==s.length()-1) return true;
                    q.add(i);
                }
            }
            farthest=Math.min(idx+maxJump,s.length()-1);
        }
        return false;
    }
}

/*TLE

        class Solution {
            public boolean[] visited;
            public boolean canReach(String s, int minJump, int maxJump) {
                visited=new boolean[s.length()];
                sol(0,s,minJump,maxJump);
                return visited[s.length()-1];
            }
            public void sol(int i,String s,int minJump,int maxJump){
                if(i>=s.length()) return;
                for(int j=i+minJump;j<=Math.min(i+maxJump,s.length()-1);j++){
                    if(s.charAt(j)=='0' && !visited[j]){
                        visited[j]=true;
                        sol(j,s,minJump,maxJump);
                    }
                }
            }
                
        }


*/
