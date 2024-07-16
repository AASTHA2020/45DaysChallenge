class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element is not equal to val
            if (nums[i] != val) {
                // Place it at the current index position
                nums[index] = nums[i];
                // Increment the index
                index++;
            }
        }
        
        // Return the number of elements that are not val
        return index;
    }
}



