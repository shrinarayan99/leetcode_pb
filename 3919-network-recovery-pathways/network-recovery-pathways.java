class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int nodes = online.length;

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for (int i = 0; i < nodes; i++) {
            list.add(new ArrayList<>());
        }

        int maxEdge = 0;
        for (int[] e : edges) {
            list.get(e[0]).add(new int[]{e[1], e[2]});
            maxEdge = Math.max(maxEdge, e[2]);
        }

        if (!online[0] || !online[nodes - 1]) return -1;

        int low = 0, high = maxEdge;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int[] distance = new int[nodes];
            Arrays.fill(distance, Integer.MAX_VALUE);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
            distance[0] = 0;
            pq.offer(new int[]{0, 0});

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();

                int cost = curr[0];
                int u = curr[1];

                if (cost != distance[u]) continue;

                for (int[] val : list.get(u)) {
                    int v = val[0];
                    int wt = val[1];

                    if (!online[v]) continue;
                    if (wt < mid) continue;

                    if ((long) cost + wt > k) continue;

                    if (distance[v] > cost + wt) {
                        distance[v] = cost + wt;
                        pq.offer(new int[]{distance[v], v});
                    }
                }
            }

            if (distance[nodes - 1] != Integer.MAX_VALUE && distance[nodes - 1] <= k) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}