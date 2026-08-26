class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];

        int dx = coordinates[1][0] - x1;
        int dy = coordinates[1][1] - y1;

        for (int i = 2; i < coordinates.length; i++) {
            int currDx = coordinates[i][0] - x1;
            int currDy = coordinates[i][1] - y1;

            if (currDx * dy != currDy * dx) {
                return false;
            }
        }

        return true;
    }
}