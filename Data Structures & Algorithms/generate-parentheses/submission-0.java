class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        parenthesis(0,0,new StringBuilder(), n, answer);
        return answer;
    }

    private void parenthesis(int openCount, int closedCount, StringBuilder current, int n, List<String> answer) {
        if(current.length()==2*n) {
            answer.add(current.toString());
            return;
        }
        if(openCount < n) {
            current.append('(');
            parenthesis(openCount + 1, closedCount, current, n, answer);
            current.deleteCharAt(current.length()-1);
        }
        if(closedCount < openCount) {
            current.append(')');
            parenthesis(openCount, closedCount + 1, current, n, answer);
            current.deleteCharAt(current.length()-1);
        }
    }
}
