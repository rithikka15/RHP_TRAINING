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

            for (int i = 0; i < n; i++) {
                freq[fs.nextInt()]++;
            }

            int[] suffix = new int[m + 2];

            for (int i = m; i >= 1; i--) {
                suffix[i] = suffix[i + 1] + freq[i];
            }

            int ans = 0;

            for (int x = 1; x <= m; x++) {
                int cur = suffix[x];

                if (2 * x <= m) {
                    cur += freq[2 * x];
                }

                ans = Math.max(ans, cur);
            }

            out.append(ans).append('\n');
        }

        System.out.print(out);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
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
                res = res * 10 + (c - '0');
                c = read();
            }

            return res;
        }
    }
}
