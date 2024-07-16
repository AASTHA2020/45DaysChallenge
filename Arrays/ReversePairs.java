class Solution {
    public int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }
    
    private int mergeSortAndCount(int[] nums, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = left + (right - left) / 2;
        int count = mergeSortAndCount(nums, left, mid) + mergeSortAndCount(nums, mid + 1, right);
        
        // Counting the reverse pairs during merge step
        count += merge(nums, left, mid, right);
        
        return count;
    }
    
    private int merge(int[] nums, int left, int mid, int right) {
        int count = 0;
        int[] sorted = new int[right - left + 1];
        int i = left;    // Pointer for the left half
        int j = mid + 1; // Pointer for the right half
        int k = 0;       // Pointer for the sorted array
        
        // Count the reverse pairs
        while (i <= mid) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
            i++;
        }
        
        // Merge two sorted arrays
        i = left;
        j = mid + 1;
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                sorted[k++] = nums[i++];
            } else {
                sorted[k++] = nums[j++];
            }
        }
        
        while (i <= mid) {
            sorted[k++] = nums[i++];
        }
        
        while (j <= right) {
            sorted[k++] = nums[j++];
        }
        
        // Copy sorted array back to nums
        System.arraycopy(sorted, 0, nums, left, sorted.length);
        
        return count;
    }
}


// Detailed Comments:
// mergeSortAndCount: This method recursively divides the array into halves (left to mid and mid + 1 to right) and returns the total count of reverse pairs.
// merge: This method is responsible for merging two sorted halves (left to mid and mid + 1 to right) while counting the reverse pairs.
// Count Calculation: During the merge, the while (i <= mid) loop counts how many elements in the right half (j <= right) satisfy the condition nums[i] > 2 * nums[j]. This count is accumulated in count.
// System.arraycopy: After merging, the sorted array is copied back to nums to reflect the sorted order.
// Complexity:
// Time Complexity: O(n log n) due to the merge sort implementation.
// Space Complexity: O(n) due to the auxiliary array used for merging.
// This approach efficiently counts the reverse pairs using a divide-and-conquer strategy combined with the merge sort technique, ensuring optimal performance for large inputs as specified by the problem constraints.









