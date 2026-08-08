class Solution {
    int[] E2 = new int[10], E3 = new int[10], E5 = new int[10], E7 = new int[10];
    int aMax, bMax;
    int[][] minDigits;

    public String smallestNumber(String num, long t) {
        long tt = t;
        int a = 0, b = 0, c = 0, d = 0;
        while (tt % 2 == 0) {
            tt /= 2;
            a++;
        }
        while (tt % 3 == 0) {
            tt /= 3;
            b++;
        }
        while (tt % 5 == 0) {
            tt /= 5;
            c++;
        }
        while (tt % 7 == 0) {
            tt /= 7;
            d++;
        }
        if (tt != 1)
            return "-1";

        int[][] dig = {
                { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 2, 0, 0, 0 },
                { 0, 0, 1, 0 }, { 1, 1, 0, 0 }, { 0, 0, 0, 1 }, { 3, 0, 0, 0 }, { 0, 2, 0, 0 }
        };
        for (int x = 1; x <= 9; x++) {
            E2[x] = dig[x][0];
            E3[x] = dig[x][1];
            E5[x] = dig[x][2];
            E7[x] = dig[x][3];
        }

        aMax = a;
        bMax = b;
        int INF = Integer.MAX_VALUE / 2;
        minDigits = new int[aMax + 1][bMax + 1];
        for (int[] row : minDigits)
            Arrays.fill(row, INF);
        minDigits[0][0] = 0;
        int[][] opts = { { 1, 0 }, { 0, 1 }, { 2, 0 }, { 1, 1 }, { 3, 0 }, { 0, 2 } };
        for (int i = 0; i <= aMax; i++) {
            for (int j = 0; j <= bMax; j++) {
                if (i == 0 && j == 0)
                    continue;
                int best = INF;
                for (int[] op : opts) {
                    int pi = Math.max(0, i - op[0]);
                    int pj = Math.max(0, j - op[1]);
                    if (minDigits[pi][pj] + 1 < best)
                        best = minDigits[pi][pj] + 1;
                }
                minDigits[i][j] = best;
            }
        }

        int n = num.length();
        int[] D = new int[n];
        for (int i = 0; i < n; i++)
            D[i] = num.charAt(i) - '0';

        int z = n;
        for (int i = 0; i < n; i++)
            if (D[i] == 0) {
                z = i;
                break;
            }
        int pmax = z;

        long[] prefA = new long[pmax + 1], prefB = new long[pmax + 1];
        long[] prefC = new long[pmax + 1], prefD = new long[pmax + 1];
        for (int i = 0; i < pmax; i++) {
            int x = D[i];
            prefA[i + 1] = prefA[i] + E2[x];
            prefB[i + 1] = prefB[i] + E3[x];
            prefC[i + 1] = prefC[i] + E5[x];
            prefD[i + 1] = prefD[i] + E7[x];
        }

        StringBuilder result = null;

        for (int p = pmax; p >= 0 && result == null; p--) {
            long ra = Math.max(0, a - prefA[p]);
            long rb = Math.max(0, b - prefB[p]);
            long rc = Math.max(0, c - prefC[p]);
            long rd = Math.max(0, d - prefD[p]);

            if (p == n) {
                if (ra == 0 && rb == 0 && rc == 0 && rd == 0)
                    result = new StringBuilder(num);
                continue;
            }

            int lower = (p < z) ? D[p] + 1 : 1;
            if (lower > 9)
                continue;
            int k = n - p - 1;

            for (int x = lower; x <= 9; x++) {
                long na = Math.max(0, ra - E2[x]);
                long nb = Math.max(0, rb - E3[x]);
                long nc = Math.max(0, rc - E5[x]);
                long nd = Math.max(0, rd - E7[x]);
                if (feasible(na, nb, nc, nd, k)) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < p; i++)
                        sb.append((char) ('0' + D[i]));
                    sb.append((char) ('0' + x));
                    fillSuffix(sb, na, nb, nc, nd, k);
                    result = sb;
                    break;
                }
            }
        }

        if (result != null)
            return result.toString();

        long need = c + d + minDigits[a][b];
        int L = (int) Math.max(n + 1, need);
        StringBuilder sb = new StringBuilder();
        fillSuffix(sb, a, b, c, d, L);
        return sb.toString();
    }

    boolean feasible(long a, long b, long c, long d, long k) {
        if (a < 0 || b < 0 || c < 0 || d < 0)
            return false;
        int ai = (int) Math.min(a, aMax);
        int bi = (int) Math.min(b, bMax);
        long need = c + d + minDigits[ai][bi];
        return need <= k;
    }

    void fillSuffix(StringBuilder sb, long a, long b, long c, long d, long k) {
        for (long pos = 0; pos < k; pos++) {
            for (int x = 1; x <= 9; x++) {
                long na = Math.max(0, a - E2[x]);
                long nb = Math.max(0, b - E3[x]);
                long nc = Math.max(0, c - E5[x]);
                long nd = Math.max(0, d - E7[x]);
                if (feasible(na, nb, nc, nd, k - pos - 1)) {
                    sb.append((char) ('0' + x));
                    a = na;
                    b = nb;
                    c = nc;
                    d = nd;
                    break;
                }
            }
        }
    }
}