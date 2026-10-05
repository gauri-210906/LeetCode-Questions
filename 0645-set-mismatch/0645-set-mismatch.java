class Solution {
    
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        int dup = -1;
        int mis = -1;

        for(int i=1; i<=n; i++){
            int count = 0;

            for(int j=0; j<n; j++){

                if(nums[j] == i){
                    count++;
                }
            }

            if(count == 2) dup = i;
            if(count == 0) mis = i;
        }


        return new int[]{dup, mis};
    }
}