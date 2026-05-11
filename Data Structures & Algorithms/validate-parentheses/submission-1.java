class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();

        for(int i = 0; i < c.length; i++) {
            if(c[i] == '(' || c[i] == '{' || c[i] == '[') {
                stack.push(c[i]);
            }
            if(c[i] == ')' || c[i] == '}' || c[i] == ']') {
                if(stack.isEmpty()) {
                    return false;
                } else {
                    char z = stack.pop();
                    if(c[i] == ')' && z=='(') {
                        continue;
                    }
                    if(c[i] == '}' && z=='{') {
                        continue;
                    }
                    if(c[i] == ']' && z=='[') {
                        continue;
                    }
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
