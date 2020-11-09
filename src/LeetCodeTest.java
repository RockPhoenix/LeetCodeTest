import java.util.LinkedList;
import java.util.Stack;

public class LeetCodeTest {
    public static void main(String[] args) {
        System.out.println(isValid("(}"));
    }

    public static boolean isValid(String s) {
        if(s.isEmpty())return true;
        if(s.length() % 2 != 0)return false;
        Stack<Character> stack = new Stack<>();
        for (char symbol : s.toCharArray()){
            switch(symbol){
                case ')':
                    if (stack.empty())return false;
                    if (stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '}':
                    if (stack.empty())return false;
                    if (stack.peek() == '{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case ']':
                    if (stack.empty())return false;
                    if (stack.peek() == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                default:
                    stack.push(symbol);
                    break;
            }
        }
        return stack.empty();
    }
}
