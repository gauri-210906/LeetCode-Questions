class Solution {
    
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int[] count = new int[n + 1];

        int dup = -1;
        int mis = -1;

        for(int num : nums){
            count[num]++;  // frequency- [1,2,0,1]
        }

        for(int i=1; i<=n; i++){

            if(count[i] == 2) dup = i;
            if(count[i] == 0) mis = i;
        }


        return new int[]{dup, mis};
    }
}