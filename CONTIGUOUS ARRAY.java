import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        map.put(0, -1);

        for (int i = 0; i < n; i++) {

            if (nums[i] == 0) {
                sum--;
            } else {
                sum++;
            }

            if (map.containsKey(sum)) {

                int len = i - map.get(sum);

                if (len > maxLen) {
                    maxLen = len;
                }

            } else {

                map.put(sum, i);
            }
        }

        System.out.println(maxLen);
    }
}
