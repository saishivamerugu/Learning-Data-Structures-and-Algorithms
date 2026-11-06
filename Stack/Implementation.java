import java.util.*;

public class Implementation{
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        System.out.println(stack);

        int popedElement = stack.pop();
        System.out.println("popped element is " + popedElement + " remaining elements are " + stack);

        int topElement = stack.peek();
        System.out.println("top element is " + topElement);

        int sizeOfStack = stack.size();
        System.out.println("size of stack is " + sizeOfStack);

        boolean isExist = stack.isEmpty();
        System.out.println(
            isExist ? "Elements not Exist empty" : "Elements Exist not empty"
        );
        fixedSizeApproach();
    }

    public static void fixedSizeApproach(){
        int[] stack = new int[5];
        int top = -1;
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("1. push");
            System.out.println("2. pop");
            System.out.println("3. peek");
            System.out.println("4. size");
            System.out.println("5. isEmpty");

            int value = sc.nextInt();
            int n = stack.length;

            switch (value) {
                case 1: 
                        if(top == n - 1) {
                            System.out.println("OverFlow of stack, size exceeded unable to insert");
                        } else {
                            System.out.print("Enter the element : ");
                            int element = sc.nextInt();
                            stack[++top] = element;
                            System.out.println("Element inserted into stack " + element);
                        }
                    break;
                        
                case 2: 
                        if(top == -1){
                            System.out.println("UndeFlow of the stack, No elements in the stack exists");
                        } else {
                            int poppedElement = stack[top];
                            top--;
                            System.out.println("popped element is " + poppedElement);
                        }
                    break;
                
                case 3: 
                        if(top == -1) System.out.println("Stack is empty... no peek element");
                        else {
                            System.out.println("peek element is " + stack[top]);
                        }
                    break;
            
                case 4: 
                        System.out.println(
                            top == -1 ? "Empty" : "Not Empty"
                        );
                    break;

                case 5: 
                        if(top == -1) System.out.println("No elements exist - size = 0");
                        else {
                            System.out.println(top+1 + " is the size of the element");
                        }
                    break;
                    
                default: System.out.println("Enter correct option");
                    break;
            }
        }
        
    }
}