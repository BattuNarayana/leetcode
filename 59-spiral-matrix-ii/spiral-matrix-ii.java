class Solution {
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;

        while (num <= n * n) {
            for (int col = left; col <= right; col++) {
                matrix[top][col] = num++;
            }
            top++;

            // 2️⃣ top → bottom
            for (int row = top; row <= bottom; row++) {
                matrix[row][right] = num++;
            }
            right--;

            // 3️⃣ right → left
            for (int col = right; col >= left; col--) {
                matrix[bottom][col] = num++;
            }
            bottom--;

            // 4️⃣ bottom → top
            for (int row = bottom; row >= top; row--) {
                matrix[row][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}