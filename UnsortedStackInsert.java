// class Stack {
//     private int maxSize;
//     private int[] stackArray;
//     private int top;

//     public Stack(int size) {
//         maxSize = size;
//         stackArray = new int[maxSize];
//         top = -1;
//     }

//     public void push(int value) {
//         if (isFull()) {
//             System.out.println("Stack Overflow");
//         } else {
//             stackArray[++top] = value;
//             System.out.println(value + " pushed to stack");
//         }
//     }

//     public void pop() {
//         if (isEmpty()) {
//             System.out.println("Stack Underflow");
//         } else {
//             System.out.println(stackArray[top--] + " popped from stack");
//         }
//     }

//     public void peek() {
//         if (isEmpty()) {
//             System.out.println("Stack is empty");
//         } else {
//             System.out.println("Top element is " + stackArray[top]);
//         }
//     }

//     public boolean isEmpty() {
//         return (top == -1);
//     }

//     public boolean isFull() {
//         return (top == maxSize - 1);
//     }

//     public void display() {
//         if (isEmpty()) {
//             System.out.println("Stack is empty");
//         } else {
//             System.out.print("Stack elements: ");
//             for (int i = 0; i <= top; i++) {
//                 System.out.print(stackArray[i] + " ");
//             }
//             System.out.println();
//         }
//     }
// }

// public class StackDemo {
//     public static void main(String[] args) {
//         Stack stack = new Stack(5);
//         stack.push(10);
//         stack.push(20);
//         stack.push(30);
//         stack.display();
//         stack.peek();
//         stack.pop();
//         stack.display();
//     }
// 



// class Node {
//     int data;
//     Node next;
//     Node(int d) {
//         data = d;
//         next = null;
//     }
// }

// class Stacklist {
//     Node top = null;

//     public void push(int value) {
//         Node newNode = new Node(value);
//         newNode.next = top;
//         top = newNode;
//         System.out.println(value + " pushed to stack");
//     }

//     public void pop() {
//         if (isEmpty()) {
//             System.out.println("Stack Underflow");
//         } else {
//             System.out.println(top.data + " popped from stack");
//             top = top.next;
//         }
//     }

//     public void peek() {
//         if (top == null) {
//             System.out.println("Stack is empty");
//         } else {
//             System.out.println("Top element is " + top.data);
//         }
//     }

//     public boolean isEmpty() {
//         return top == null;
//     }

//     public void display() {
//         if (top == null) {
//             System.out.println("Stack is empty");
//         } else {
//             System.out.print("Stack elements: ");
//             Node temp = top;
//             while (temp != null) {
//                 System.out.print(temp.data + " ");
//                 temp = temp.next;
//             }
//             System.out.println();
//         }
//     }
// }

// public class StackDemo {
//     public static void main(String[] args) {
//         Stacklist stack = new Stacklist();
//         stack.push(10);
//         stack.push(20);
//         stack.push(30);
//         stack.display();
//         stack.peek();
//         stack.pop();
//         stack.display();
//     }
// }




// import java.util.Stack;

// public class SortedStackInsert {
//     public static void insertSorted(Stack<Integer> stack, int value) {
//         Stack<Integer> temp = new Stack<>();
//         while (!stack.isEmpty() && stack.peek() > value) {
//             temp.push(stack.pop());
//         }
//         stack.push(value);
//         while (!temp.isEmpty()) {
//             stack.push(temp.pop());
//         }
//     }
//     public static void main(String[] args) {
//         Stack<Integer> stack = new Stack<>();
//         stack.push(1);
//         stack.push(3);
//         stack.push(4);

//         System.out.println("Original stack: " + stack);

//         insertSorted(stack, 2);

//         System.out.println("After inserting : " + stack);
//     }
// }

import java.util.Stack;

public class UnsortedStackInsert {

    public static void sortStack(Stack<Integer> stack) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int current = stack.pop();
            while (!temp.isEmpty() && temp.peek() > current) {
                stack.push(temp.pop());
            }
            temp.push(current);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }


    public static void insertSorted(Stack<Integer> stack, int value) {
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty() && stack.peek() > value) {
            temp.push(stack.pop());
        }
        stack.push(value);
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(4);
        stack.push(1);
        stack.push(3);

        System.out.println("Original unsorted stack: " + stack);

        sortStack(stack);
        System.out.println("Sorted stack: " + stack);

        insertSorted(stack, 2);
        System.out.println("After inserting 2: " + stack);
    }
}