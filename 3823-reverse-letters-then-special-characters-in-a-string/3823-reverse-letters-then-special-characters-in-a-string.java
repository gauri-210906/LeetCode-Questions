class Solution {

    public String reverseByType(String s) {

        StringBuilder letters = new StringBuilder();
        StringBuilder special = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                letters.append(ch);
            } else {
                special.append(ch);
            }
        }

        char[] arr = s.toCharArray();

        int l = letters.length() - 1;
        int sp = special.length() - 1;

        // Put reversed characters back
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] >= 'a' && arr[i] <= 'z') {
                arr[i] = letters.charAt(l);
                l--;
            } 
            else {
                arr[i] = special.charAt(sp);
                sp--;
            }
        }

        return new String(arr);
    }
}