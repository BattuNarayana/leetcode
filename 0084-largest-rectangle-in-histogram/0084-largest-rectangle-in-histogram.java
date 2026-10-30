class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            left[i] = stk.isEmpty() ? -1 : stk.peek();
            stk.push(i);
        }
        stk.clear();
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && heights[stk.peek()]>=heights[i]){
                stk.pop();
            }
            right[i] = stk.isEmpty() ? n : stk.peek();
            stk.push(i);
        }
        int area = 0;
        for(int i=0;i<n;i++){
            int w = right[i]-left[i]-1;
            int h = heights[i];
            area = Math.max(area, w*h);
        }
        return area;
    }
}