import java.util.*;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] a = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {
            a[i] = 1L * nums[i] * nums[i];
        }

        Arrays.sort(a);

        int n = a.length;
        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (i < (n + 1) / 2) {
                ans += a[n - 1 - i];
            } else {
                ans -= a[n - 1 - i];
            }
        }

        return ans;
    }
}