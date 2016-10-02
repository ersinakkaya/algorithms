package StacksAndQueues;

public class ReverseString {

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<Character>();
        String reverseString = "";
        for (int i = 0; i < s.length(); i++) {
        	stack.push(s.charAt(i));
        }
        
        for (int i = 0; i < s.length(); i++) {
        	reverseString += stack.pop();
        }
        
        return reverseString;
    }


    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseString(s));
    }
}