class Solution {
    public String longestCommonPrefix(String[] strs) {
        // Edge case: if the input array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Initialize the prefix with the first string
        String prefix = strs[0];
        
        // Iterate through the rest of the strings
        for (int i = 1; i < strs.length; i++) {
            // Update the prefix by comparing it with the current string
            while (strs[i].indexOf(prefix) != 0) {
                // Reduce the prefix length by one character each time
                prefix = prefix.substring(0, prefix.length() - 1);
                // If the prefix becomes empty, return an empty string
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        // Return the longest common prefix
        return prefix;
    }
}