class Solution {
    public String[] findWords(String[] words) {
        // Define the three rows of the American keyboard
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            // Convert word to lowercase for case-insensitive comparison
            String lowerWord = word.toLowerCase();
            int targetRow = getRowNumber(lowerWord.charAt(0), row1, row2, row3);
            
            boolean isValid = true;
            for (int i = 1; i < lowerWord.length(); i++) {
                if (getRowNumber(lowerWord.charAt(i), row1, row2, row3) != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
    
    // Helper method to determine which row a character belongs to
    private int getRowNumber(char c, String r1, String r2, String r3) {
        if (r1.indexOf(c) != -1) return 1;
        if (r2.indexOf(c) != -1) return 2;
        return 3;
    }
}