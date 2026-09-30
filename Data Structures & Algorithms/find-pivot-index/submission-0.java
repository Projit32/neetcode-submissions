class Solution {
    public int pivotIndex(int[] nums) {
        int[] prefixSum = new int[nums.length];
        int[] postfixSum = new int[nums.length];
        
        int preTotal = 0;
        int postTotal = 0;
        for(int i = 0; i< nums.length; i++){
            preTotal+= nums[i];
            prefixSum[i] = preTotal;

            postTotal+= nums[nums.length-i-1];
            postfixSum[nums.length-i-1] = postTotal;
        }

        for(int i = 0; i < nums.length; i++){
            int preSum = (i==0)? 0: prefixSum[i-1];
            int postSum = (i==nums.length-1)? 0 : postfixSum[i+1];
            if (preSum == postSum)
                return i;
        }
        return -1;

    }
}