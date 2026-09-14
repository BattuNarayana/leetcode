class Solution {

    public void nextPermutation(int[] nums) {

        int n = nums.length;
        int i = n - 2;
        int breakidx = -1;

       // Step 1: Find the Breakpoint
        while (i >= 0) {

            if (nums[i] < nums[(i + 1) % n]) {
                breakidx = i;
                break;
            }

            i--;

        }
        // Step 2: If No Breakpoint Exists
        if (breakidx == -1) {
            reverse(0, n - 1, nums);
            return;
        }

        //Step 3: Find the Slightly Greater Element
        for (int j = n - 1; j > breakidx; j--) {

            if (nums[j] > nums[breakidx]) {

                //swap
                int temp = nums[breakidx];
                nums[breakidx] = nums[j];
                nums[j] = temp;
                break;
            }

        }
        //Step 4: Reverse the Suffix
        reverse(breakidx + 1, n - 1, nums);
    }

    public void reverse(int start, int last, int[] nums) {

        while (start < last) {
            int temp = nums[start];
            nums[start] = nums[last];
            nums[last] = temp;
            start++;
            last--;
        }
    }
}
//Please click the ⬆️ UPARROW ⬆️ button in the bottom left corner of your screen

//That means you Like👍the solution