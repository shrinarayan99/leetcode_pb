class Solution {
    public String[] createGrid(int m, int n) {
        String[] path=new String[m];
        for(int i=0;i<m;i++){
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<n;j++){
                if(i==0) sb.append('.');
                else{
                    sb.append('#');
                }
            }
            sb.setCharAt(n-1,'.');
            path[i]=new String(sb);
        }
        return path;
    }
}