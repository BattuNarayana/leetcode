class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        String s = "";

        int i = n - 1;
        int j = m - 1;
        int rem = 0;

        while (i >= 0 || j >= 0) {
            int p = 0;

            if (i >= 0) p += num1.charAt(i) - '0';
            if (j >= 0) p += num2.charAt(j) - '0';
            p += rem;

            s = (p % 10) + s;
            rem = p / 10;

            i--;
            j--;
        }

        if (rem > 0) s = rem + s;

        return s;
    }
}
