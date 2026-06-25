class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int length = temperatures.length;
        int[] ans = new int[length];

        for(int i = 0; i < length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int k = stack.pop();
                ans[k] = i - k;
            }
            stack.push(i);
        }

        return ans;
    }
}
