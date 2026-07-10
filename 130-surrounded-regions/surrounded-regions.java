class Solution {
    void dfs(int i, int j, char[][] board){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j]!='O') return;
        
        board[i][j] = 'S';
        dfs(i-1,j, board);
        dfs(i, j+1, board);
        dfs(i+1, j, board);
        dfs(i, j-1, board);
    }
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;
        // first row;
        for(int i=0;i<n;i++){
            if(board[0][i]=='O') dfs(0, i, board);
        }
        // first column
        for(int i=0;i<m;i++){
            if(board[i][0]=='O') dfs(i, 0, board);
        }
        // bottom row
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O') dfs(m-1, i, board);
        }
        // last column
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O') dfs(i, n-1, board);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O') board[i][j]= 'X';
                else if(board[i][j]=='S') board[i][j]='O';
            }
        }
    }
}