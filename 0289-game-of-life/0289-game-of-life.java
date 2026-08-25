class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++) {
            copy[i] = board[i].clone();
        }

        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                int live = 0;

                for (int k = 0; k < 8; k++) {
                    int nr = r + dr[k];
                    int nc = c + dc[k];

                    if (nr >= 0 && nr < m &&
                        nc >= 0 && nc < n &&
                        copy[nr][nc] == 1) {
                        live++;
                    }
                }

                if (copy[r][c] == 1) {
                    if (live < 2 || live > 3) {
                        board[r][c] = 0;
                    }
                } else {
                    if (live == 3) {
                        board[r][c] = 1;
                    }
                }
            }
        }
    }
}