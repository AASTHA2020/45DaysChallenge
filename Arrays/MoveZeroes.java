class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
       int j = -1;

        // Find the position of the first zero
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero is found, return since the array is already correct
        if (j == -1) {
            return;
        }
      for (int i = j + 1; i < n; i++) {
            if (nums[i] != 0) {
                // Swap 
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move the position of the first zero one step ahead
                j++;
            }
        }
    }
}