class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= heights.length ; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            while(!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int index = stack.pop();
                int heightOfRectangle = heights[index];
                int width;
                if(stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }

                maxArea = Math.max(maxArea, heightOfRectangle*width);
            }
            stack.push(i);
        }

        return maxArea;
    }
}

