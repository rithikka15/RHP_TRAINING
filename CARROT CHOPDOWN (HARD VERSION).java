import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {
            int n = fs.nextInt();
            int m = fs.nextInt();

            int[] freq = new int[m + 1];
            long total = 0;

            for (int i = 0; i < n; i++) {
                int x = fs.nextInt();
                freq[x]++;
                total += x;
            }

            long[] suffix = new long[m + 2];

            for (int i = m; i >= 1; i--) {
                suffix[i] = suffix[i + 1] + freq[i];
            }

            long[] ans = new long[m + 1];

            int maxK = 0;
            long power = 1;

            while (power <= m) {
                maxK++;
                power <<= 1;
            }

            for (int k = 1; k < maxK; k++) {
                int limit = (1 << k) - 1;
                int full = 1 << k;

                long best = 0;

                for (int x = 1; x <= m; x++) {
                    long cur = 0;

                    int maxMultiple = Math.min(limit, m / x);

                    for (int j = 1; j <= maxMultiple; j++) {
                        cur += suffix[j * x];
                    }

                    if ((long) full * x <= m) {
                        cur += freq[full * x];
                    }

                    best = Math.max(best, cur);
                }

                ans[k] = best;
            }

            for (int k = maxK; k <= m; k++) {
                ans[k] = total;
            }

            for (int k = 1; k <= m; k++) {
                if (k > 1) out.append(' ');
                out.append(ans[k]);
            }

            out.append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int res = 0;

            while (c > ' ') {
                res = res * 10 + c - '0';
                c = read();
            }

            return res;
        }
    }
}
