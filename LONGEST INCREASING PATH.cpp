class Solution {
public:

    int dfs(vector<vector<int>>& matrix, vector<vector<int>>& dp,
            int row, int col) {

        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        int R = matrix.size();
        int C = matrix[0].size();

        int ans = 1;   

        if (row > 0 && matrix[row - 1][col] > matrix[row][col]) {
            ans = max(ans, 1 + dfs(matrix, dp, row - 1, col));
        }

        if (row < R - 1 && matrix[row + 1][col] > matrix[row][col]) {
            ans = max(ans, 1 + dfs(matrix, dp, row + 1, col));
        }

        if (col > 0 && matrix[row][col - 1] > matrix[row][col]) {
            ans = max(ans, 1 + dfs(matrix, dp, row, col - 1));
        }

        if (col < C - 1 && matrix[row][col + 1] > matrix[row][col]) {
            ans = max(ans, 1 + dfs(matrix, dp, row, col + 1));
        }

        dp[row][col] = ans;
        return ans;
    }

    int longestIncreasingPath(vector<vector<int>>& matrix) {

        int R = matrix.size();
        int C = matrix[0].size();

        vector<vector<int>> dp(R, vector<int>(C, 0));

        int maxLen = 1;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < C; col++) {

                maxLen = max(maxLen,
                             dfs(matrix, dp, row, col));
            }
        }

        return maxLen;
    }
};
