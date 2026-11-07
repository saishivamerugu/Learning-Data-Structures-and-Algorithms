import java.util.Stack;


public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "{[()]}()";
        System.out.println(checkValidParenthesis(str));
        System.out.println(checkValidParenthesisOptimal(str));
    }


    public static boolean checkValidParenthesis(String str) {
        String s = str;
        while (true) {
            String previous = s;
            s = s.replace("()", "");
            s = s.replace("[]", "");
            s = s.replace("{}", "");
            if (s.equals(previous)) {
                break;
            }
        }
        return s.isEmpty();
    }

    public static boolean checkValidParenthesisOptimal(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char s = str.charAt(i);
            if (s == '(' || s == '[' || s == '{') {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if ((s == ')' && top != '(') || (s == ']' && top != '[') || s == '}' && top != '{') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}