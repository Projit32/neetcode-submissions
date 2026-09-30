class NumArray {

    int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length];

        int currSum = 0;
        for(int i=0; i< nums.length; i++){
            currSum+=nums[i];
            sums[i] = currSum;
        }
    }
    
    public int sumRange(int left, int right) {
        
        int leftSum = (left > 0)? sums[left-1]: 0;
        int rightSum = sums[right];
        return rightSum - leftSum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */