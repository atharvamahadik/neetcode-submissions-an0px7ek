class Solution {
    public String simplifyPath(String path) {
        String[] paths = path.split("/");
        Stack<String> stack = new Stack<>();

        for(String token : paths) {
            if(token.equals("") || token.equals(".")) {
                continue;
            }
            else if(token.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else{
                stack.push(token);
            }
        }

        return "/" + String.join("/",stack);
    }
}