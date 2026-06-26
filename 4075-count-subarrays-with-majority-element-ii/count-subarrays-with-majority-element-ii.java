import java.util.*;

class Solution {

    class SegmentTree {
        int[] tree;
        int n;

        SegmentTree(int n) {
            this.n = n;
            tree = new int[4 * n];
        }

        void update(int node, int start, int end, int idx) {
            if (start == end) {
                tree[node]++;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid)
                update(2 * node, start, mid, idx);
            else
                update(2 * node + 1, mid + 1, end, idx);

            tree[node] = tree[2 * node] + tree[2 * node + 1];
        }

        int query(int node, int start, int end, int l, int r) {
            if (r < start || end < l)
                return 0;

            if (l <= start && end <= r)
                return tree[node];

            int mid = (start + end) / 2;

            return query(2 * node, start, mid, l, r)
                    + query(2 * node + 1, mid + 1, end, l, r);
        }
    }

    public long countMajoritySubarrays(int[] nums, int target) {

        int n = nums.length;

        // Prefix sums after converting
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (nums[i] == target ? 1 : -1);
        }

        // Coordinate Compression
        long[] sorted = prefix.clone();
        Arrays.sort(sorted);

        Map<Long, Integer> map = new HashMap<>();
        int idx = 0;

        for (long x : sorted) {
            if (!map.containsKey(x))
                map.put(x, idx++);
        }

        SegmentTree st = new SegmentTree(idx);

        long ans = 0;

        // Insert prefix[0]
        st.update(1, 0, idx - 1, map.get(prefix[0]));

        for (int i = 1; i <= n; i++) {

            int pos = map.get(prefix[i]);

            // Count previous prefix sums < current prefix sum
            if (pos > 0)
                ans += st.query(1, 0, idx - 1, 0, pos - 1);

            st.update(1, 0, idx - 1, pos);
        }

        return ans;
    }
}