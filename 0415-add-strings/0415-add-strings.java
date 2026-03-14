class Solution {
    public String addStrings(String num1, String num2) {
        int n = num1.length()-1;
        int m = num2.length()-1,sum=0;
        StringBuilder sb = new StringBuilder();
        int c = 0;
        while(n>=0 || m>=0 || c!=0){
            int a = (n>=0)? num1.charAt(n)-'0' : 0;
            int b = (m>=0)? num2.charAt(m)-'0' : 0;
            sum = a+b+c;
            int d = sum%10;
            c = sum/10;
            sb.append(d);
            n--;
            m--;
        }
        return sb.reverse().toString();
    }
}