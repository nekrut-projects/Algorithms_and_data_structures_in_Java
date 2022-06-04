package lesson_3;

public class Main {
    private static class Stack {
        private int maxSize; // размер
        private int[] stack; // место хранения
        private int head;    // вершина

        public Stack(int size) {
            this.maxSize = size;
            this.stack = new int[this.maxSize];
            this.head = -1;
        }

        public boolean isEmpty() {
            return this.head == -1;
        }

        public boolean isFull() {
            return this.head == this.maxSize - 1;
        }

        public void push(int i) {
            if (isFull()) {
                this.maxSize *= 2;
                int[] newStack = new int[this.maxSize];
                System.arraycopy(this.stack, 0, newStack, 0, this.stack.length);
                this.stack = newStack;
            }
            this.stack[++this.head] = i;
        }

        public int pop() {
            if (isEmpty()) throw new RuntimeException("Stack is empty"); //ret -1
            return this.stack[this.head--];
        }

        public int peek() {
            return this.stack[this.head];
        }
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        pq.insert(5);
        pq.insert(12);
        pq.insert(9);
        pq.insert(1);
        pq.insert(8);
        pq.remove();
        pq.remove();
        pq.remove();
        pq.insert(6);
        pq.insert(3);
        pq.insert(82);
        pq.insert(7);
        pq.insert(4);
        pq.insert(2);
        pq.insert(32);
        pq.print();

        Deque deque = new Deque(10);
        deque.insertFirst(5);
        deque.insertFirst(3);
        deque.insertFirst(6);
        deque.insertFirst(9);
        deque.insertLast(7);
        deque.insertLast(1);
        deque.insertLast(2);
        deque.insertLast(3);
        deque.insertLast(11);
        deque.insertLast(12);
        deque.insertLast(15);
        deque.insertLast(25);
        deque.insertLast(35);
        deque.print();

        deque.removeFirst();
        deque.print();
        deque.removeLast();
        deque.print();

        char[][] symbols = {
                              {'{', '}'},
                              {'[', ']'},
                              {'(', ')'}
                           };
        System.out.println(check("j(vcb)jds([]}dfl",symbols));
    }

    public static int check(String input, char openSymbol, char closeSymbol) {
        Stack bracketsPosition = new Stack(10);

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == closeSymbol) {
                if (bracketsPosition.isEmpty()) {
                    bracketsPosition.push(i);
                    break;
                } else {
                    bracketsPosition.pop();
                }
            }
            if (input.charAt(i) == openSymbol) {
                bracketsPosition.push(i);
            }
        }
        if (!bracketsPosition.isEmpty()){
            return bracketsPosition.pop() + 1;
        }
        return -1;
    }

    public static int check(String input, char[][] bracketSymbols) {
        int temp = -1;
        for (int i = 0; i < bracketSymbols.length; i++) {
            temp = check(input, bracketSymbols[i][0],bracketSymbols[i][1]);
            if (temp != -1)
                break;
        }
        return temp;
    }
}


