class Solution {
    public boolean canPlaceFlowers(int[] a, int n) {
        int l = a.length;
        for (int i = 0; i < l; i++) {
            if (a[i] == 0) {
                // Check if left and right plots are empty (or out of bounds)
                boolean leftEmpty = (i == 0 || a[i - 1] == 0);
                boolean rightEmpty = (i == l - 1 || a[i + 1] == 0);
                
                if (leftEmpty && rightEmpty) {
                    a[i] = 1;
                    n--;
                    
                    if (n <= 0) {
                        return true;
                    }
                }
            }
        }
        return n<=0;
    }
}