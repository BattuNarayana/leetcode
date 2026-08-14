class Solution {

    String[] options = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    StringBuilder path;
    List<String> allPaths;

    public List<String> letterCombinations(String digits) {
        path = new StringBuilder();
        allPaths = new ArrayList<>();
        helper(digits, 0);
        return allPaths;
    }
    void helper(String digits, int i){
        if(i>=digits.length()){
            allPaths.add(path.toString());
            return;
        }
        for(char ch : options[digits.charAt(i)-'0'].toCharArray()){
            path.append(ch);
            helper(digits, i+1);
            path.setLength(path.length()-1);
        }
    }
}