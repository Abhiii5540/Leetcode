class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int sign = 1; // positive
        int r = 0;
        int i = 0;
        // skipping the spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // identify the sign whether '+' or '-' i.e. +987 or -987
        if (i < n && s.charAt(i) == '+') {
            sign = 1;
            i++;
        }
        else if (i < n && s.charAt(i) == '-') {
            sign = -1;
            i++;
        }
        // pick only digit , stops whem characyer found
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // checks overflows and underflow condition
            if ((r > Integer.MAX_VALUE / 10 || r == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            r = 10 * r + digit;
            i++;
        }
        return sign * r;
    }
}