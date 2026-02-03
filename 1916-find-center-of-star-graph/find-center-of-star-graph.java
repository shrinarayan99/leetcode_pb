class Solution {
    public int findCenter(int[][] edges) {
        int m=edges.length;
        int nodes=m+1;
        int[] arr=new int[nodes+1];
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            // mark the in degree of the graph of every node
            arr[u]+=1;
            arr[v]+=1;
        }
        for(int i=0;i<=nodes;i++){
            if(arr[i]==m){
                return i;
            }
        }
        return 0;

    }
}



/*Using adjency list(tc=O(m+n) && SC=O(n))

class Solution {
    public int findCenter(int[][] edges) {
        int m=edges.length;
        int nodes=m+1;
        ArrayList[]  arr=new ArrayList[nodes+1];
        for(int i=0;i<=nodes;i++){
            arr[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            arr[edges[i][0]].add(edges[i][1]);
            arr[edges[i][1]].add(edges[i][0]);
        }
        int ans=0;
        for(int i=0;i<=nodes;i++){
            if(arr[i].size()==m){
                ans=i;
                break;
            }
        }
        return ans;
    }
}/
*/

/* Adjecy matrix(through MLE and TLE both)


class Solution {
    public int findCenter(int[][] edges) {
        int nodes=edges.length+1;
        int[][] dp=new int[nodes+1][nodes+1];
        for(int i=0;i<edges.length;i++){
            dp[edges[i][0]][edges[i][1]]=1;
            dp[edges[i][1]][edges[i][0]]=1;
        }
        int count=0;
        int ans=-1;
        for(int i=1;i<=nodes;i++){
            for(int val:dp[i]){
                count+=val;
            }
            if(count==nodes-1){
                ans=i;
                break;
            }
            count=0;
        }
        return ans;
    }
}

*/