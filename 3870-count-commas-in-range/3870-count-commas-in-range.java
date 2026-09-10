class Solution {
    public int countCommas(int n) {
        return Math.max(n - 999, 0);
    }

    // if(n < 1000) return 0;
    // return n - 1000 + 1;
}