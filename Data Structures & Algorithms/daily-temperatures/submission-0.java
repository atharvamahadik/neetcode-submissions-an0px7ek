class Solution {
    public int[] dailyTemperatures(int[] array) {
        Stack<Integer> stack = new Stack<> ();
        int[] result = new int[array.length];

        for(int i = 0; i < array.length; i++) {
            
            while(!stack.isEmpty() && array[i] > array[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;
            }

            stack.push(i);
        }

        return result;
    }
}

/*
stack: 1 0
22 21 20
 0  1  2
 
 i = 1
 prevIndex = 

 
 0 1 2

 */


