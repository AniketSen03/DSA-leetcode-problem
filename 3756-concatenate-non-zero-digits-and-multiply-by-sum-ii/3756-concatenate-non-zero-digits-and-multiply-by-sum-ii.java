class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length(), mod = 1000000007;

        long[] pow10 = new long[n + 1];
        int[] sumD = new int[n + 1]; // Digits ka sum
        int[] cntN0 = new int[n + 1]; // Non-zero digits ka count
        long[] p = new long[n + 1]; // Substring hash (x number)

        pow10[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % mod;
            int d = s.charAt(i - 1) - '0';

            sumD[i] = sumD[i - 1] + d;
            cntN0[i] = cntN0[i - 1] + (d > 0 ? 1 : 0);
            p[i] = (d > 0) ? (p[i - 1] * 10 + d) % mod : p[i - 1];
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            int n0 = cntN0[r + 1] - cntN0[l];
            long sd = sumD[r + 1] - sumD[l];

            // Formula se 'x' nikalna bina zeros ke
            long x = (p[r + 1] - p[l] * pow10[n0] % mod + mod) % mod;
            ans[i] = (int) ((x * sd) % mod);
        }
        return ans;
    }
}