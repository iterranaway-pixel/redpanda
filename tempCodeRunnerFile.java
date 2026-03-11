import java.util.Stack;

public class asfd {
    private int maxSize;
    private int[] stackArray;
    private int top;    

 
    public Stack(int size){
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;  
    }
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack Overflow");
        } else {
            stackArray[++top] = value;
            System.out.println(value + " pushed to stack");
        }
    }
    public void pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
        } else {
            System.out.println(stackArray[top--] + " popped from stack");
        }
    }
    public void peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element is " + stackArray[top]);
        }
    }
    public boolean isEmpty() {
        return (top == -1);
    }
    public boolean isFull() {
        return (top == maxSize - 1);
    }
     public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.print("Stack elements: ");
            for (int i = 0; i <= top; i++) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println();
        }
    }
}









    public static void main(String[] args) {
        
        Stack stack = new Stack(5)

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.display();
        stack.peek();
        stack.pop();
        stack.display();

    }
    
    
}
