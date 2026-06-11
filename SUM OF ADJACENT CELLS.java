import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int R = sc.nextInt();
        int C = sc.nextInt();

        int[][] grid = new int[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int row = sc.nextInt();
        int col = sc.nextInt();

        long sum = 0;

        for (int i = row - 1; i <= row + 1; i++) {

            for (int j = col - 1; j <= col + 1; j++) {

                if (i == row && j == col) {
                    continue;
                }

                if (i >= 0 && i < R && j >= 0 && j < C) {
                    sum += grid[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}
