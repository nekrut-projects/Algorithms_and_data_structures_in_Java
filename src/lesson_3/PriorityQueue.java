package lesson_3;

public class PriorityQueue extends Queue {
    public PriorityQueue(int s) {
        super(s);
    }

    @Override
    public void insert(int val) {
        super.insert(val);
        sortMax();
    }

    private void swap(int a, int b) {
        int tmp = this.queue[a];
        this.queue[a] = this.queue[b];
        this.queue[b] = tmp;
    }

    private void sortMax() {
        if (items == 1) {
            return;
        }
        if (tail > head) {
            for (int i = tail; i > head; i--) {
                if (queue[i - 1] <  queue[i]) {
                    swap(i - 1, i);
                } else {
                    break;
                }
            }
        } else {
            for (int i = 0, j = tail; i < items; i++, j--) {
                if (j == 0) {
                    if (queue[j] > queue[maxSize-1]) {
                        swap(j, maxSize - 1);
                        j = maxSize;
                        continue;
                    }
                    break;
                }
                if (queue[j - 1] <  queue[j]) {
                    swap(j - 1, j);
                } else {
                    break;
                }
            }
        }
    }

    @Override
    public int remove() {
        return super.remove();
    }

    @Override
    public int peek() {
        return super.peek();
    }

    public void print(){
        StringBuilder sb = new StringBuilder();
        sb.append('[');

        for (int i = head, j = 0; j < items; i++, j++) {
            if (j == 0){
                sb.append(queue[i]);
                continue;
            }
            if (head > tail) {
                if (i  == maxSize){
                    i = 0;
                }
            }
            sb.append(", ");
            sb.append(queue[i]);
        }
        sb.append(']');
        System.out.println(sb);
    }
}
