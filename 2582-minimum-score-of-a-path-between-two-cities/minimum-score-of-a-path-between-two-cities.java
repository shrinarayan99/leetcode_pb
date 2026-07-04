class Solution {
    public int minScore(int n, int[][] roads) {

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] path : roads) {
            int u = path[0];
            int v = path[1];
            int cost = path[2];

            list.get(u).add(new int[]{v, cost});
            list.get(v).add(new int[]{u, cost});   // Undirected graph
        }

        Queue<Integer> q = new LinkedList<>();

        int[] minEdge = new int[n + 1];
        Arrays.fill(minEdge, Integer.MAX_VALUE);

        q.offer(1);
        minEdge[1] = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int[] val : list.get(u)) {
                int des = val[0];
                int cost = val[1];

                int newMin = Math.min(minEdge[u], cost);

                if (newMin < minEdge[des]) {
                    minEdge[des] = newMin;
                    q.offer(des);
                }
            }
        }

        return minEdge[n];
    }
}