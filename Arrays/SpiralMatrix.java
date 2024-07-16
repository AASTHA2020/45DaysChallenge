class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            
            // Traverse from top to bottom along the right boundary
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            if (top <= bottom) {
                // Traverse from right to left along the bottom boundary
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            
            if (left <= right) {
                // Traverse from bottom to top along the left boundary
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
}


// Check for Empty Input: If the matrix is null or empty, return an empty list.
// Initialize Variables: Define variables for the boundaries (top, bottom, left, right) and initialize a list (result) to store the spiral order elements.
// Spiral Traversal: Use a while loop to traverse the matrix in spiral order:
// Move Right: Traverse from left to right along the current top boundary. After traversal, increment top.
// Move Down: Traverse from top to bottom along the current right boundary. After traversal, decrement right.
// Move Left: Traverse from right to left along the current bottom boundary. After traversal, decrement bottom.
// Move Up: Traverse from bottom to top along the current left boundary. After traversal, increment left.
// Loop Until Boundaries Meet: Continue the loop until the boundaries cross each other.
// Return Result: Return the result list containing all elements in spiral order