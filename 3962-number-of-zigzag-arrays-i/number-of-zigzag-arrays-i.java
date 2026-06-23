class Solution {
    static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {

        int totalValues = r - l + 1;

        if (n == 1) return totalValues;

        long[] lastMoveUp = new long[totalValues + 1];
        long[] lastMoveDown = new long[totalValues + 1];

        // Arrays of length 2
        for (int currentValue = 1; currentValue <= totalValues; currentValue++) {
            lastMoveUp[currentValue] = currentValue - 1;
            lastMoveDown[currentValue] = totalValues - currentValue;
        }

        if (n == 2) {
            long answer = 0;

            for (int value = 1; value <= totalValues; value++) {
                answer = (answer + lastMoveUp[value] + lastMoveDown[value]) % MOD;
            }

            return (int) answer;
        }

        for (int currentLength = 3; currentLength <= n; currentLength++) {

            long[] currentUpWays = new long[totalValues + 1];
            long[] currentDownWays = new long[totalValues + 1];

            long prefixDownSum = 0;

            for (int value = 1; value <= totalValues; value++) {
                currentUpWays[value] = prefixDownSum;
                prefixDownSum = (prefixDownSum + lastMoveDown[value]) % MOD;
            }

            long suffixUpSum = 0;

            for (int value = totalValues; value >= 1; value--) {
                currentDownWays[value] = suffixUpSum;
                suffixUpSum = (suffixUpSum + lastMoveUp[value]) % MOD;
            }

            lastMoveUp = currentUpWays;
            lastMoveDown = currentDownWays;
        }

        long answer = 0;

        for (int value = 1; value <= totalValues; value++) {
            answer = (answer + lastMoveUp[value] + lastMoveDown[value]) % MOD;
        }

        return (int) answer;
    }
}