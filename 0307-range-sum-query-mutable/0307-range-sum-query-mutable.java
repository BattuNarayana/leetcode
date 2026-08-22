class NumArray {
    public int n;
    public int[] st;
    private int[] nums;

    public NumArray(int[] nums) {
        n = nums.length;
        this.nums = nums;

        st = new int[4 * n];
        build_st(0, 0, n - 1);
    }

    void build_st(int idx, int ss, int se) {
        // ss = segment start
        // se = segment end

        if (ss == se) {
            st[idx] = nums[ss];
            return;
        }

        int mid = ss + (se - ss) / 2;

        build_st(2 * idx + 1, ss, mid);
        build_st(2 * idx + 2, mid + 1, se);

        st[idx] = st[2 * idx + 1] + st[2 * idx + 2];
    }

    public void update(int index, int val) {
        update_val(0, 0, n - 1, index, val);
    }

    void update_val(int idx, int ss, int se, int i, int newVal) {

        // Reach the leaf corresponding to index i
        while (ss < se) {
            int mid = ss + (se - ss) / 2;

            if (i <= mid) {
                idx = 2 * idx + 1;
                se = mid;
            } else {
                idx = 2 * idx + 2;
                ss = mid + 1;
            }
        }

        // Difference between new and old value
        int extra = newVal - st[idx];

        // Update leaf
        st[idx] += extra;

        // Propagate difference to ancestors
        while (idx > 0) {
            idx = (idx - 1) / 2;
            st[idx] += extra;
        }
    }

    public int sumRange(int qs, int qe) {
        return sum(0, 0, n - 1, qs, qe);
    }

    int sum(int idx, int ss, int se, int qs, int qe) {

        // No overlap
        if (qe < ss || qs > se)
            return 0;

        // Complete overlap
        if (ss >= qs && se <= qe)
            return st[idx];

        int mid = ss + (se - ss) / 2;

        int left = sum(2 * idx + 1, ss, mid, qs, qe);
        int right = sum(2 * idx + 2, mid + 1, se, qs, qe);

        return left + right;
    }
}