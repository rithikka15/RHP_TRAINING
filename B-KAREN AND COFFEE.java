import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int q = sc.nextInt();

        int max = 200000;

        int[] arr = new int[max + 2];

        // Mark the ranges
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            arr[left]++;
            arr[right + 1]--;
        }

        // Find how many recipes cover each position
        for (int i = 1; i <= max; i++) {
            arr[i] += arr[i - 1];
        }

        int[] prefix = new int[max + 1];

        // Build prefix array directly
        for (int i = 1; i <= max; i++) {
            prefix[i] = prefix[i - 1];

            if (arr[i] >= k) {
                prefix[i]++;
            }
        }

        // Answer queries
        while (q-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            System.out.println(prefix[right] - prefix[left - 1]);
        }
    }
}
