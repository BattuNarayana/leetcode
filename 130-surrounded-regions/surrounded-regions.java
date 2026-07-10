class Solution {
    void dfs(int i, int j, char[][] board, boolean[][] visited){
        int m = visited.length, n = visited[0].length;
        if(i<0 || j<0 || i>=m || j>=n || board[i][j]=='X' || visited[i][j]) return;
        
        visited[i][j] = true;
        dfs(i-1,j, board, visited);
        dfs(i, j+1, board, visited);
        dfs(i+1, j, board, visited);
        dfs(i, j-1, board, visited);
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        // first row;
        for(int i=0;i<n;i++){
            if(board[0][i]=='O') dfs(0, i, board, visited);
        }
        // first column
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(i, 0, board, visited);
        }
        // bottom row
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O') dfs(m-1, i, board, visited);
        }
        // last column
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O') dfs(i, n-1, board ,visited);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && board[i][j]=='O') board[i][j]= 'X';
            }
        }
    }
}