class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n + 1];
        return solve(n, memo);
    }

    public int solve(int n, int[] memo) {
        if (n < 4)
            return n;

        if (memo[n] != 0)
            return memo[n];

        int ans = n;

        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            ans = Math.min(ans, 1 + solve(n - square, memo));
        }

        memo[n] = ans;
        return ans;
    }
}