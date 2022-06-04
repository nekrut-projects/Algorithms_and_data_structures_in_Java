package lesson_3;

public class Queue {
    protected int maxSize; // размер
    protected int[] queue; // место хранения
    protected int head;    // отсюда уходят
    protected int tail;    // сюда приходят
    protected int items;   // текущее количество

    public Queue(int s) {
        maxSize = s;
        queue = new int[maxSize];
        head = 0;
        tail = -1;
        items = 0;
    }

    public boolean isEmpty() {
        return (items == 0);
    }

    public boolean isFull() {
        return (items == maxSize);
    }

    public int size() {
        return items;
    }

    public void insert(int val) {
        if (isFull()) {
            maxSize *= 2;
            int[] tmpArr = new int[maxSize];
            if (tail >= head) {
                System.arraycopy(queue, 0, tmpArr, 0, queue.length);
            } else {
                System.arraycopy(queue, 0, tmpArr, 0, tail + 1);
                System.arraycopy(queue, head, tmpArr,
                        maxSize - (queue.length - head), queue.length - head);
                head = maxSize - head - 1;
            }
            queue = tmpArr;
        }
        if (tail == maxSize - 1) {
            tail = -1;
        }
        queue[++tail] = val;
        ++items;
    }

    public int remove() {
        int temp = queue[head];
        queue[head++] = 0;
        head %= maxSize;
        items--;
        return temp;
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int getItems() {
        return items;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public void setTail(int tail) {
        this.tail = tail;
    }

    public void setItems(int items) {
        this.items = items;
    }

    public int peek() {
        return queue[head];
    }
}
