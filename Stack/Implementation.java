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
        System.out.println(isExist ? "Elements not Exist empty" : "Elements Exist not empty");

        // Implementation using the array
        //fixedSizeApproach();
        usingLinkedList();
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
                        if(top == -1) System.out.println("UndeFlow of the stack, No elements in the stack exists");
                        else {
                            int poppedElement = stack[top--];
                            System.out.println("popped element is " + poppedElement);
                        }
                        break;
                
                case 3: 
                        if(top == -1) System.out.println("Stack is empty... no peek element");
                        else System.out.println("peek element is " + stack[top]);
                        break;
            
                case 4: 
                        System.out.println(top == -1 ? "Empty" : "Not Empty");
                         break;

                case 5: 
                        if(top == -1) System.out.println("No elements exist - size = 0");
                        else System.out.println(top+1 + " is the size of the element");
                        break;
                    
                default: 
                        System.out.println("Enter correct option");
                        break;
            }
        }
    }

    public static void usingLinkedList() {

        Node top = null;
        int size = 0;

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Size");
            System.out.println("5. isEmpty");
            System.out.println("6. Display");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter data: ");
                    int data = sc.nextInt();
                    Node newNode = new Node(data);
                    newNode.next = top;
                    top = newNode;
                    size++;
                    System.out.println("Element inserted: " + data);
                    break;

                case 2:

                    if (top == null) System.out.println("Stack Underflow! Stack is empty.");
                    else {
                        int poppedElement = top.data;
                        top = top.next;
                        size--;
                        System.out.println("Popped element: " + poppedElement);
                    }
                    break;

                case 3:
                    if (top == null) System.out.println("Stack is empty. No peek element.");
                    else System.out.println("Peek element: " + top.data);
                    break;

                case 4:
                    System.out.println("Stack size: " + size);
                    break;

                case 5:
                    System.out.println(top == null
                            ? "Stack is empty"
                            : "Stack is not empty");
                    break;

                case 6:
                    if (top == null) System.out.println("Stack is empty.");
                    else {
                        Node current = top;
                        System.out.print("Stack elements: ");
                        while (current != null) {
                            System.out.print(current.data + " ");
                            current = current.next;
                        }
                        System.out.println();
                    }
                    break;

                case 7 : 
                    return;

                default:
                    System.out.println("Enter a valid option.");
                    break;
            }
        }
    }
}

class Node {

    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/*
In my linked-list implementation, I perform both insertion and deletion at the head of the linked list. The top pointer always points to the most recently inserted element.
When I push 10 and then 20, the new node containing 20 becomes the head, and its next pointer references the node containing 10.
Therefore, when I traverse the linked list starting from top, I get 20 followed by 10. This represents the stack's LIFO (Last In, First Out) behaviour."
*/
