import java.util.Stack;

class BracesCouple {
    public static int longestValidParentheses(String s) {
        Stack<Character> pStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                pStack.push('(');
                indexStack.push(i+1);
            }
            if (s.charAt(i) == ')' && !pStack.isEmpty() && pStack.peek() == '(') {
                pStack.pop();
                indexStack.pop();
            }
            else if (s.charAt(i) == ')' && pStack.isEmpty()){
                indexStack.push(i+1);
            }

        }
        if(indexStack.isEmpty()) return s.length();
        indexStack.push(s.length() + 1);
        int prevIndex = 0;
        int diff = 0;
        for (int index : indexStack) {
            diff = Math.max(diff, index - prevIndex -1);
            prevIndex = index;
        }

        return diff;
    }

    public static void main(String[] args) {
        String s = ")()())";
        String o = "(()";
        String l = "())";
        String j  = "(()()(";
        System.out.println(longestValidParentheses(o));
    }
}