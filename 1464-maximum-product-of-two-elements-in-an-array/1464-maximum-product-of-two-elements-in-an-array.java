class Solution {
    public int maxProduct(int[] nums) {
        int mx1 = 0; // largest
        int mx2 = 0; // sec largest

        for(int n : nums){
            mx2 = Math.max(mx2, Math.min(mx1,n));
            mx1 = Math.max(mx1, n);

        }

        return (mx1 - 1) * (mx2 - 1);

    }
}