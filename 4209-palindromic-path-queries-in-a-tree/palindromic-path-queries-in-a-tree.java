
import java.util.*;

class Solution {
    int n, LOG, timer;
    int[] tin, tout, depth, euler, parent;
    int[][] up;
    int[] bit;
    int[] mask;
    char[] s;
    List<Integer>[] adj;

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        this.s = s.toCharArray();

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) LOG++;

        tin = new int[n];
        tout = new int[n];
        depth = new int[n];
        euler = new int[n];
        parent = new int[n];
        up = new int[LOG][n];
        mask = new int[n];
        bit = new int[n + 2];

        buildTree();

        // Initial root-to-node character masks.
        for (int u = 0; u < n; u++) {
            rangeXor(tin[u], tout[u], 1 << (this.s[u] - 'a'));
        }

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] parts = q.split(" ");

            if (parts[0].equals("update")) {
                int u = Integer.parseInt(parts[1]);
                char c = parts[2].charAt(0);

                int change =
                    (1 << (this.s[u] - 'a')) ^ (1 << (c - 'a'));

                rangeXor(tin[u], tout[u], change);
                this.s[u] = c;

            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);

                int lca = getLCA(u, v);

                int pathMask = pointQuery(tin[u])
                             ^ pointQuery(tin[v])
                             ^ (1 << (this.s[lca] - 'a'));

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }

    void buildTree() {
        timer = 0;

        // Iterative DFS: entry and exit events.
        int[] stackNode = new int[2 * n + 5];
        int[] stackParent = new int[2 * n + 5];
        boolean[] exit = new boolean[2 * n + 5];

        int top = 0;
        stackNode[top] = 0;
        stackParent[top] = 0;
        exit[top++] = false;

        while (top > 0) {
            --top;
            int u = stackNode[top];
            int p = stackParent[top];
            boolean isExit = exit[top];

            if (isExit) {
                tout[u] = timer;
                continue;
            }

            parent[u] = p;
            up[0][u] = p;
            for (int k = 1; k < LOG; k++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }

            tin[u] = timer;
            euler[timer++] = u;

            stackNode[top] = u;
            stackParent[top] = p;
            exit[top++] = true;

            for (int i = adj[u].size() - 1; i >= 0; i--) {
                int v = adj[u].get(i);
                if (v == p) continue;

                depth[v] = depth[u] + 1;
                stackNode[top] = v;
                stackParent[top] = u;
                exit[top++] = false;
            }
        }
    }

    int getLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) return u;

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return up[0][u];
    }

    void add(int i, int value) {
        for (; i < bit.length; i += i & -i) {
            bit[i] ^= value;
        }
    }

    int prefixXor(int i) {
        int result = 0;
        for (; i > 0; i -= i & -i) {
            result ^= bit[i];
        }
        return result;
    }

    // XOR the half-open Euler interval [l, r).
    void rangeXor(int l, int r, int value) {
        add(l + 1, value);
        add(r + 1, value);
    }

    int pointQuery(int pos) {
        return prefixXor(pos + 1);
    }
}


/*MANAGE PARENT AND CHECK FOR EVERY QUERY{ TC / INCOMPELTE}

class Solution {
    List<Boolean> ans;
    int[] parent;
    int[] size;
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        ans=new ArrayList<>();
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<>();
        }

        for(int[]e:edges){
            int u=e[0];
            int v=e[1];
            dsu(u,v);
        }
        char[] ch=s.toCharArray();

        
    }
    public void dsu(int u,int v){
        int ul_parent_u=find(u);
        int ul_parent_v=find(v);

        if(ul_parent_u==ul_parent_v) return;
        if(size[ul_parent_u]>size[ul_parent_v]){
            parent[ul_parent_v]=ul_parent_u;
            size[ul_parent_u]+=size[ul_parent_v];
        }
        else{
            parent[ul_parent_u]=ul_parent_v;
            size[ul_parent_v]+=size[ul_parent_u];
        }
    }
    public int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }
}

*/