class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color) return image;
        dfs(image, sr, sc, image.length, image[0].length, color, image[sr][sc]);
        return image;
    }
    void dfs(int[][] image, int i, int j, int row, int col, int color, int toChange){
        if(i<0 || j<0 || i>=row || j>=col || image[i][j]!=toChange) return;
        image[i][j] = color;
        int[] x = {-1, 0, 1, 0};
        int[] y = {0, 1, 0, -1};
        for(int k=0;k<4;k++){
            dfs(image, i+x[k], j+y[k], row, col, color, toChange);
        }
    }
}