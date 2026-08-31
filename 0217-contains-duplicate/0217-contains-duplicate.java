class Solution {
    public boolean containsDuplicate(int[] nums) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();

        for(int num : nums){
            if(set.contains(num)){
                return true;
            }
            set.add(num);
        }

        return false;
    }
}