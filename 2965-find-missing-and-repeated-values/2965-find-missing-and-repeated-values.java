class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();

        int rep = -1;
        int actualSum = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                actualSum += grid[i][j];

                if(set.contains(grid[i][j])){
                    rep = grid[i][j];
                }

                set.add(grid[i][j]);
            }
        }

        int expSum = (n * n * (n * n + 1)) / 2;

        int mis = expSum -actualSum + rep;

        return new int[]{rep, mis};
        
    }
}