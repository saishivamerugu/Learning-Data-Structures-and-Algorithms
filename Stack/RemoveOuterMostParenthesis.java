public class RemoveOuterMostParenthesis {
    public static void main(String[] args) {
        
        String str = "(()())(())";
        
        bruteForceApproach(str);
        removeOuterParentheses(str);
    }

    public static void bruteForceApproach(String str){
        int start = 0; 
        int depth = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            
            if(ch == '(') depth++;
            if(ch == ')') depth--;

            if(depth == 0){
                String group = str.substring(start, i+ 1);
                result.append(group.substring(1,group.length()-1));
                start = i + 1;
            }
        } System.out.println(result);
    }

    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (depth > 0) result.append(ch);
                depth++;
            } else {
                depth--;
                if (depth > 0) result.append(ch);
            }
        }
        return result.toString();
    }
}

/*
1. Create an empty StringBuilder to store the answer.
2. Set start = 0.
3. Set depth = 0.
4. Read each character from left to right.
5. If the character is (, increase depth.
6. If the character is ), decrease depth.
7. Whenever depth becomes zero, we have reached the end of one primitive group.
8. Extract the group using substring(start, i + 1).
9. Remove its first and last characters.
10. Add the remaining characters to the answer.
11. Set start = i + 1 to begin the next group.
12. Return the final answer.
*/
