class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        int k = Math.max(num1.length(), num2.length());
        char[] result = new char[k + 1];

        while (i >= 0 || j >= 0 || carry > 0) {
            int sum = carry;
            if (i >= 0) {
                sum += num1.charAt(i--) - '0';
            }

            if (j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            result[k--] = (char) ('0' + sum % 10);
            carry = sum / 10;
        }

        int start = k + 1;
        return new String(result, start, result.length - start);
    }
}
