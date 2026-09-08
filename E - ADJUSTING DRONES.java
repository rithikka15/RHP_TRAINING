import java.io.*;
import java.util.*;

public class Main {

    static int n, k;
    static int[] a, b, parent;

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    static void buildB() {
        int max = 4 * n + 5;

        parent = new int[max];

        for (int i = 0; i < max; i++)
            parent[i] = i;

        for (int i = n - 1; i >= 0; i--) {
            int pos = find(a[i]);
            b[i] = pos;
            parent[pos] = find(pos + 1);
        }
    }

    static boolean check(int moves) {
        int[] cnt = new int[4 * n + 5];

        for (int i = 0; i < n; i++) {
            int value = Math.min(a[i] + moves, b[i]);
            cnt[value]++;

            if (cnt[value] > k)
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner(System.in);
        StringBuilder out = new StringBuilder();

        int t = fs.nextInt();

        while (t-- > 0) {

            n = fs.nextInt();
            k = fs.nextInt();

            a = new int[n];
            b = new int[n];

            for (int i = 0; i < n; i++)
                a[i] = fs.nextInt();

            Arrays.sort(a);

            buildB();

            int low = 0;
            int high = 3 * n;

            while (low < high) {
                int mid = (low + high) / 2;

                if (check(mid))
                    high = mid;
                else
                    low = mid + 1;
            }

            out.append(low).append('\n');
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

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int res = 0;

            while (c > ' ') {
                res = res * 10 + c - '0';
                c = read();
            }

            return res * sign;
        }
    }
}
