class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length ; i++) {
            
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int temp = stack.pop();
                ans[temp] = i - temp;
            }
            stack.push(i);
        }

        return ans;
    }
}

