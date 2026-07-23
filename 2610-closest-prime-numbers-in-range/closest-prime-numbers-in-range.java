class Solution {
    boolean[] isComposite;

    public int[] closestPrimes(int left, int right) {
        if (right < 2) {
            return new int[]{-1, -1};
        }

        int[] ans = {-1, -1};
        int prevPrime = -1;
        int minGap = Integer.MAX_VALUE;

        isComposite = new boolean[right + 1];
        buildSieve(right);

        for (int i = Math.max(left, 2); i <= right; i++) {
            if (!isComposite[i]) {
                if (prevPrime != -1) {
                    if (i - prevPrime < minGap) {
                        minGap = i - prevPrime;
                        ans[0] = prevPrime;
                        ans[1] = i;

                        // Minimum possible gap between two distinct primes
                        if (minGap == 2) {
                            return ans;
                        }
                    }
                }
                prevPrime = i;
            }
        }

        return ans;
    }

    private void buildSieve(int n) {
        isComposite[0] = true;
        isComposite[1] = true;

        for (int i = 2; i * i <= n; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
    }
}