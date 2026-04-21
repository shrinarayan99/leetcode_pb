class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n=source.length;
        int[] size=new int[n];
        int[] parent=new int[n];

        for(int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }
        for(int[] val:allowedSwaps){
            int u=val[0];
            int v=val[1];

            DSU(u,v,size,parent);
        }

          // 🔥 map: parent -> (value -> count)
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        // fill frequencies from source
        for (int i = 0; i < n; i++) {
            int p = find(i, parent);

            map.putIfAbsent(p, new HashMap<>());
            HashMap<Integer, Integer> freq = map.get(p);

            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
        }

        int count = 0;

        // try matching with target
        for (int i = 0; i < n; i++) {
            int p = find(i, parent);

            HashMap<Integer, Integer> freq = map.get(p);
            int val = target[i];

            if (freq.getOrDefault(val, 0) > 0) {
                freq.put(val, freq.get(val) - 1);
            } else {
                count++;
            }
        }
        return count;
    }
    public static void DSU(int u,int v,int[] size,int[] parent){
        int ul_u=find(u,parent);
        int ul_v=find(v,parent);

        if(ul_u==ul_v)return;

        if(size[ul_v]>size[ul_u]){
            parent[ul_u]=ul_v;
            size[ul_v]+=size[ul_u];
        }
        else{
            parent[ul_v]=ul_u;
            size[ul_u]+=size[ul_v];
        }
    }
    public static int find(int x,int[] parent){
        if(x==parent[x]) return x;

        return parent[x]=find(parent[x],parent);
    }
}