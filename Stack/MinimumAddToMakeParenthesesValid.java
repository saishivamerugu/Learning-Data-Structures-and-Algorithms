public class MinimumAddToMakeParenthesesValid {
    public static void main(String[] args) {
        String str1 = "(()";
        String str2 = "(())";
        findParenthesesValid(str1);
        findParenthesesValid(str2);
    }

    public static void findParenthesesValid(String s){
        int open = 0, close = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(') open++;
            else if (ch == ')') {
                if(open > 0){
                    open--;
                } else {
                    close++;
                }
            }
        } System.out.println(open + close);
    }
}
