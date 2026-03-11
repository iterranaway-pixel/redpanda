class A {
   
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;

    
    public void insert(int value) {
        Node newNode = new Node(value);

       
            newNode.next = head;
            head = newNode;
            return;
        }

        
        Node current = head;
        while (current.next != null && current.next.data < value) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        question_1 list = new question_1();

        int[] numbers = {7, 3, 9, 1, 5, 2};

        for (int num : numbers) {
            list.insert(num);
        }

        System.out.println("Sorted Linked List:");
        list.display();
    }
}