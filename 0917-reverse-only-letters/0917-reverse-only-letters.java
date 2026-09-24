class Solution {

    public boolean isLetter(char c) {
        return (c >= 'a' && c <= 'z') ||
               (c >= 'A' && c <= 'Z');
    }

    public String reverseOnlyLetters(String s) {
        char[] a = s.toCharArray();

        int i = 0;
        int j = a.length - 1;

        while (i < j) {

            if (!isLetter(a[i])) {
                i++;
                continue;
            }

            if (!isLetter(a[j])) {
                j--;
                continue;
            }

            char temp = a[i];
            a[i] = a[j];
            a[j] = temp;

            i++;
            j--;
        }

        return new String(a);
    }
}