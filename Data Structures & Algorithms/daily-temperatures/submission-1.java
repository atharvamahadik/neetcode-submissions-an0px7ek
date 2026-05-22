class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        for(int i = 0; i < arr.length; i++) {
            
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}


/*
30 38 30 36 35 40 28
 0  1  2. 3. 4. 5. 6

i: 
stack:6 5
prevIndex: 1
result[prevIndex]= i - prevIndex;

result:
1 4 1.2 1
0 1 2 3 4 5 6

*/