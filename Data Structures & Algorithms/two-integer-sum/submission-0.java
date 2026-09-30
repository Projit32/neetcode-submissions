class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> compliment = new HashMap<>();
        int[] sol = new int[2];
        for(int i = 0; i< nums.length; i++){
            int diff = target - nums[i];
            if(compliment.containsKey(nums[i])){
                sol = new int[]{compliment.get(nums[i]), i};
                break;
            }
            compliment.put(diff, i);
            System.out.println(diff+" "+i);
        }
        return sol;
    }
}
