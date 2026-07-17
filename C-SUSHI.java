import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[m];

        // Input first array
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Input second array
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b);

        int i = n - 1;
        int j = m - 1;
        int count = 0;

        while (i >= 0 && j >= 0) {
            if (b[j] <= 2 * a[i]) {
                count++;
                i--;
                j--;
            } else {
                j--;
            }
        }

        System.out.println(count);
    }
}
