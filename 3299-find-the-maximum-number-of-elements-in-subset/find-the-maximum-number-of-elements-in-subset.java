class Solution {
    public int maximumLength(int[] nums) {
        Arrays.sort(nums);

        HashMap<Long, Integer> map = new HashMap<>();
        for (int val : nums) {
            map.put((long) val, map.getOrDefault((long) val, 0) + 1);
        }

        int result = 1;

        // Special handling for 1
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            result = Math.max(result, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for (Map.Entry<Long, Integer> e : map.entrySet()) {
            long key = e.getKey();

            if (key == 1) continue;

            if (e.getValue() >= 2) {
                int count = 1;
                long curr = key;

                while (true) {
                    curr = curr * curr;

                    if (curr > Integer.MAX_VALUE || !map.containsKey(curr))
                        break;

                    if (map.get(curr) >= 2) {
                        count++;
                    } else {
                        count++;
                        break;
                    }
                }

                result = Math.max(result, 2 * (count - 1) + 1);
            }
        }

        return result;
    }
}