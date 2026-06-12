class Solution {

    ArrayList<ArrayList<Integer>> list;
    int[] lowestCommanAncestor;
    int[] numberOfEdges;
    boolean[] visited;


    // array for biinary lifting
    int[][] up;
    int LOG = 18;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        list = new ArrayList<>();

        int n = edges.length;
        int nodes = n + 1;

        while ((1 << LOG) <= nodes) {
            LOG++;
        }

        lowestCommanAncestor = new int[nodes + 1];
        numberOfEdges = new int[nodes + 1];
        visited = new boolean[nodes + 1];

        up = new int[nodes + 1][LOG];

        for (int i = 0; i <= nodes; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] val : edges) {
            int u = val[0];
            int v = val[1];

            list.get(u).add(v);
            list.get(v).add(u);
        }

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[] {1, 0});

        visited[1] = true;
        lowestCommanAncestor[1] = 1;
        numberOfEdges[1] = 0;

        up[1][0] = 1;

        for (int j = 1; j < LOG; j++) {
            up[1][j] = 1;
        }

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            for (int val : list.get(curr[0])) {

                if (!visited[val]) {

                    visited[val] = true;

                    q.add(new int[] {val, curr[1] + 1});

                    lowestCommanAncestor[val] = curr[0];
                    numberOfEdges[val] = curr[1] + 1;

                    up[val][0] = curr[0];

                    for (int j = 1; j < LOG; j++) {
                        up[val][j] =
                            up[
                                up[val][j - 1]
                              ][j - 1];
                    }
                }
            }
        }

        int[] ans = new int[queries.length];
        int idx = 0;

        for (int[] qr : queries) {

            int u = qr[0];
            int v = qr[1];

            int ancestor = lca(u, v);

            int edge =
                    numberOfEdges[u]
                    + numberOfEdges[v]
                    - 2 * numberOfEdges[ancestor];

            if (edge == 0) {
                ans[idx++] = 0;
            } else {
                ans[idx++] = power(edge - 1);
            }
        }

        return ans;
    }

    // binary lifting

    public int lca(int u, int v) {

        if (numberOfEdges[u] < numberOfEdges[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = numberOfEdges[u] - numberOfEdges[v];

        for (int j = 0; j < LOG; j++) {

            if ((diff & (1 << j)) != 0) {
                u = up[u][j];
            }
        }

        if (u == v) {
            return u;
        }

        for (int j = LOG - 1; j >= 0; j--) {

            if (up[u][j] != up[v][j]) {

                u = up[u][j];
                v = up[v][j];
            }
        }

        return up[u][0];
    }

    // bit manipulation poer function O(log edges)
    public int power(int edge){

    long ans = 1;
    long base = 2;
    long mod = 1000000007L;

    while(edge > 0){

        if((edge & 1) == 1){
            ans = (ans * base) % mod;
        }

        base = (base * base) % mod;
        edge >>= 1;
    }

    return (int)ans;
}

//O(edges)
    // public int power(int edge) {

    //     long ans = 1;
    //     long mod = 1000000007L;

    //     while (edge > 0) {
    //         ans = (ans * 2) % mod;
    //         edge--;
    //     }

    //     return (int) ans;
    // }
}



// class Solution {
//     ArrayList<ArrayList<Integer>> list;
//     int[] lowestCommanAncestor;
//     int[] numberOfEdges;
//     boolean[] visited;
    

//     public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
//         list=new ArrayList<>();
        
//         int n=edges.length;
//         int nodes=n+1;

//         lowestCommanAncestor=new int[nodes+1];
//         numberOfEdges=new int[nodes+1];
//         visited=new boolean[nodes+1];


//         for(int i=0;i<=n+1;i++){
//             list.add(new ArrayList<>());
//         }

//         for(int[] val:edges){
//             int u=val[0];
//             int v=val[1];

//             list.get(u).add(v);
//             list.get(v).add(u);
//         }

//         Queue<int[]> q=new LinkedList<>();
//         q.add(new int[] {1,0});
//         visited[1]=true;
//         lowestCommanAncestor[1]=1;
//         numberOfEdges[1]=0;    
//         while(!q.isEmpty()){
//             int[] curr=q.poll();
//             for(int val:list.get(curr[0])){
//                 if(!visited[val]){
//                     visited[val]=true;
//                     q.add(new int[] {val,curr[1]+1});
//                     lowestCommanAncestor[val]=curr[0];
//                     numberOfEdges[val]=curr[1]+1;
//                 }
//             }
//         }

//         int[] ans=new int[queries.length];
//         int idx=0;

//         for (int i = 0; i < queries.length; i++) {

//             int u = queries[i][0];
//             int v = queries[i][1];

//             if (u == v) {
//                 ans[i] = 0;
//                 continue;
//             }

//             HashSet<Integer> parents = new HashSet<>();

//             int temp = u;
//             while (true) {
//                 parents.add(temp);
//                 if (temp == 1) break;
//                 temp = lowestCommanAncestor[temp];
//             }

//             int ancestor = 1;

//             temp = v;
//             while (true) {

//                 if (parents.contains(temp)) {
//                     ancestor = temp;
//                     break;
//                 }

//                 if (temp == 1) break;

//                 temp = lowestCommanAncestor[temp];
//             }

//             int edgeCount =
//                     (numberOfEdges[u] - numberOfEdges[ancestor]) +
//                     (numberOfEdges[v] - numberOfEdges[ancestor]);

//             ans[i] = power(edgeCount - 1);
//         }
//         return ans;

//     }
//     public int power(int edge){
//         long ans=1;
//         while(edge>0){
//             ans=(ans*2)%1000000007;
//             edge--;
//         }
//         return (int)ans;
//     }
// }