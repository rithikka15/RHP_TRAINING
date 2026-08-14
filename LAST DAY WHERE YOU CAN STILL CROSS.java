class Solution {

    int[] leader;

    int find(int x) {
        if (leader[x] == x)
            return x;

        leader[x] = find(leader[x]);
        return leader[x];
    }

    void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b)
            leader[b] = a;
    }

    public int latestDayToCross(int row, int col, int[][] cells) {

        int n = row * col;

        leader = new int[n + 2];

        for (int i = 0; i < n + 2; i++)
            leader[i] = i;

        boolean[][] land = new boolean[row][col];

        int top = n;
        int bottom = n + 1;

        for (int day = cells.length - 1; day >= 0; day--) {

            int r = cells[day][0] - 1;
            int c = cells[day][1] - 1;

            land[r][c] = true;

            int current = r * col + c;

            if (r == 0)
                union(current, top);

            if (r == row - 1)
                union(current, bottom);

            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};

            for (int k = 0; k < 4; k++) {

                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr >= 0 && nr < row &&
                    nc >= 0 && nc < col &&
                    land[nr][nc]) {

                    int next = nr * col + nc;
                    union(current, next);
                }
            }

            if (find(top) == find(bottom))
                return day;
        }

        return 0;
    }
}
