package StacksAndQueues;

public class Parentheses {
    private static final char PAREN_OPEN    = '(';
    private static final char PAREN_CLOSE   = ')';
    private static final char BRACE_OPEN    = '{';
    private static final char BRACE_CLOSE   = '}';
    private static final char BRACKET_OPEN  = '[';
    private static final char BRACKET_CLOSE = ']';

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case PAREN_OPEN:
                    stack.push(PAREN_OPEN);
                    break;
                case BRACE_OPEN:
                    stack.push(BRACE_OPEN);
                    break;
                case BRACKET_OPEN:
                    stack.push(BRACKET_OPEN);
                    break;
                case PAREN_CLOSE:
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != PAREN_OPEN) 
                        return false;
                    break;
                case BRACE_CLOSE:
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != BRACE_OPEN)
                        return false;
                    break;
                case BRACKET_CLOSE:
                    if (stack.isEmpty())
                        return false;
                    if (stack.pop() != BRACKET_OPEN)
                        return false;
                    break;

                default:
                    //ignore other characters
                    break;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        //String s = "[()]{}{[()()]()}";//should return true
        String s = "[(])";//should return false
        System.out.println(isBalanced(s));
    }

}