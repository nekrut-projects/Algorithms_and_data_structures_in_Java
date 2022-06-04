package lesson_3;

public class Deque {
    private int maxSize; // размер
    private int[] deque; // место хранения
    private int head;
    private int tail;
    private int items;   // текущее количество

    public Deque(int maxSize) {
        this.maxSize = maxSize;
        this.deque = new int[maxSize];
        this.items = 0;
        this.head = -1;
        this.tail = -1;
    }

    public int size() {
        return items;
    }

    public boolean isFull() {
        return items == maxSize;
    }

    public boolean isEmpty(){
        return items == 0;
    }

    private void increaseArray(){
        int[] oldDeque = deque;
        maxSize *= 2;
        deque = new int[maxSize];

        if (tail >= head) {
            System.arraycopy(oldDeque, head, deque, 0, tail - head);
        } else {
            System.arraycopy(oldDeque, head, deque, 0, oldDeque.length - head);
            System.arraycopy(oldDeque, 0, deque, oldDeque.length - head, tail + 1);
            head = 0;
            tail = items - 1;
        }
    }

    public void insertFirst(int value){
        if (items == 0){
            tail = head = 0;
            deque[head] = value;
            items++;
            return;
        }
        if (isFull()){
            increaseArray();
        }
        if (head == 0){
            head = maxSize;
        }
        deque[--head] = value;
        items++;

    }

    public void insertLast(int value){
        if (items == 0){
            head++;
        }
        if (isFull()){
            increaseArray();
        }
        if (tail == maxSize - 1){
            tail = -1;
        }
        deque[++tail] = value;
        items++;
    }

    public int peekFirst() {
        return deque[head];
    }

    public int peekLast() {
        return deque[tail];
    }

    public int removeFirst() {
        int temp = deque[head];
        deque[head++] = 0;
        if (head == maxSize-1) {
            head = -1;
        }
        items--;
        return temp;
    }

    public int removeLast() {
        int temp = deque[tail];
        deque[tail--] = 0;
        if (tail == 0) {
            tail = maxSize;
        }
        items--;
        return temp;
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = head, j = 0; j < items; i++, j++) {
            if (j == 0){
                sb.append(deque[i]);
                continue;
            }
            if (head > tail) {
                if (i == maxSize){
                    i = 0;
                }
            }
            sb.append(", ");
            sb.append(deque[i]);
        }
        sb.append(']');
        System.out.println(sb);
    }
}
