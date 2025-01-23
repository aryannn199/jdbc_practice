package SortingAlgortihms;

public class LinkedList {
    public class SinglyLinkedList {
        private Node head;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }

        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public void delete(int data) {
            if (head == null) return;
            if (head.data == data) {
                head = head.next;
                return;
            }
            Node temp = head;
            while (temp.next != null && temp.next.data != data) {
                temp = temp.next;
            }
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }


    public class CircularLinkedList {
        private Node last;

        private static class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
            }
        }

        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last;
            } else {
                newNode.next = last.next;
                last.next = newNode;
                last = newNode;
            }
        }

        public void insertAtBeginning(int data) {
            Node newNode = new Node(data);
            if (last == null) {
                last = newNode;
                last.next = last;
            } else {
                newNode.next = last.next;
                last.next = newNode;
            }
        }

        public void delete(int data) {
            if (last == null) return;

            Node temp = last, prev = null;
            do {
                if (temp.next.data == data) {
                    temp.next = temp.next.next;
                    if (temp.next == last) last = temp;
                    return;
                }
                prev = temp;
                temp = temp.next;
            } while (temp != last);
        }

        public void display() {
            if (last == null) return;
            Node temp = last.next;
            do {
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            } while (temp != last.next);
            System.out.println("back to start");
        }
    }

    public class DoublyLinkedList {
        private Node head;

        private static class Node {
            int data;
            Node prev, next;

            Node(int data) {
                this.data = data;
            }
        }

        public void insertAtEnd(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.prev = temp;
        }

        public void delete(int data) {
            if (head == null) return;
            if (head.data == data) {
                head = head.next;
                if (head != null) head.prev = null;
                return;
            }
            Node temp = head;
            while (temp != null && temp.data != data) {
                temp = temp.next;
            }
            if (temp != null) {
                temp.prev.next = temp.next;
                if (temp.next != null) temp.next.prev = temp.prev;
            }
        }

        public void display() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + " <-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public class Queue {
        private int[] arr;
        private int front, rear, size, capacity;

        public Queue(int capacity) {
            this.capacity = capacity;
            arr = new int[capacity];
            front = 0;
            rear = -1;
            size = 0;
        }

        public void enqueue(int data) {
            if (size == capacity) return;
            rear = (rear + 1) % capacity;
            arr[rear] = data;
            size++;
        }

        public int dequeue() {
            if (size == 0) return -1;
            int data = arr[front];
            front = (front + 1) % capacity;
            size--;
            return data;
        }

        public void display() {
            for (int i = 0; i < size; i++) {
                System.out.print(arr[(front + i) % capacity] + " ");
            }
            System.out.println();
        }
    }

    public class Stack {
        private int[] arr;
        private int top;

        public Stack(int capacity) {
            arr = new int[capacity];
            top = -1;
        }

        public void push(int data) {
            if (top == arr.length - 1) return;
            arr[++top] = data;
        }

        public int pop() {
            if (top == -1) return -1;
            return arr[top--];
        }

        public void display() {
            for (int i = 0; i <= top; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }

//    public static void main(String[] args) {
//        System.out.println("Singly Linked List:");
//        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.insertAtEnd(10);
//        sll.insertAtEnd(20);
//        sll.display();
//        sll.delete(10);
//        sll.display();
//
//        System.out.println("\nCircular Linked List:");
//        CircularLinkedList cll = new CircularLinkedList();
//        cll.insertAtEnd(10);
//        cll.insertAtEnd(20);
//        cll.display();
//
//        System.out.println("\nDoubly Linked List:");
//        DoublyLinkedList dll = new DoublyLinkedList();
//        dll.insertAtEnd(10);
//        dll.insertAtEnd(20);
//        dll.display();
//
//        System.out.println("\nQueue:");
//        Queue queue = new Queue(5);
//        queue.enqueue(10);
//        queue.enqueue(20);
//        queue.display();
//
//        System.out.println("\nStack:");
//        Stack stack = new Stack(5);
//        stack.push(10);
//        stack.push(20);
//        stack.display();
//    }
}
