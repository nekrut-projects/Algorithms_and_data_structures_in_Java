package lesson_4;

public class MyLinkedList {
    private class Node {
        private Cat cat;
        private Node next;
        private Node previous;

        private Node(Cat cat) {
            this.cat = cat;
        }

        @Override
        public String toString() {
            return "[ " + cat.toString() + " ]";
        }
    }

    private Node first;
    private Node last;
    private int size;
    private ListIterator iterator;

    public ListIterator getIterator() {
        if (this.iterator == null) {
            this.iterator = new ListIterator(first);
        }
        return this.iterator;
    }

    public void addFirst(Cat cat) {
        Node newNode = new Node(cat);
        if (size == 0) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        newNode.next = first;
        first = newNode;
        size++;
    }

    public void addLast(Cat cat) {
        Node newNode = new Node(cat);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.previous = last;
        last = newNode;
        ++size;
    }

    public Cat peekLast() {
        return last.cat;
    }

    public Cat peekFirst() {
        return first.cat;
    }

    public int size() {
        return size;
    }

    public void remove(Cat cat) {
        if (size == 0)
            return;
        Node current = first;

        while (!current.cat.equals(cat)) {
            current = current.next;
            if (current == null) return;
        }

        deleteItem(current);
    }

    private void deleteItem(Node node) {
        if (node.next == null) {
            last = node.previous;
            last.next = null;
        } else if (node.previous == null) {
            first = node.next;
            first.previous = null;
        } else {
            node.previous.next = node.next;
            node.next.previous = node.previous;
        }
    }

    public boolean isContains(Cat cat) {
        if (size == 0)
            return false;
        Node current = first;
        while (!current.cat.equals(cat)) {
            if (current.next == null) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ ");

        Node current = first;
        while (current != null) {
            sb.append(current);
            current = current.next;
            sb.append(current == null ? " }" : ", ");
        }
        return sb.toString();
    }

    class ListIterator{
        private Node current;

        private ListIterator(Node node) {
            this.current = node;
        }

        public void reset() {
            current = first;
        }

        public Cat next() {
            Cat cat = null;
            if (current.next != null){
                current = current.next;
                cat = current.cat;
            }
            return cat;
        }

        public Cat previous() {
            Cat cat = null;
            if (current.previous != null){
                current = current.previous;
                cat = current.cat;
            }
            return cat;
        }

        public Cat getCurrent() {
            return current.cat;
        }

        public boolean atEnd() {
            return current == last ? true : false;
        }

        public boolean atBegin() {
            return current == first ? true : false;
        }

        public void deleteCurrent() {
            deleteItem(current);
            current = current.next;
        }

        public void insertAfter(Cat cat) {
            Node newNode = new Node(cat);
            if (!atEnd()) {
                newNode.next = current.next;
                current.next.previous = newNode;
            }
            current.next = newNode;
            newNode.previous = current;
        }

        public void insertBefore(Cat cat) {
            Node newNode = new Node(cat);
            if (!atBegin()) {
                newNode.previous = current.previous;
                current.previous.next = newNode;
            }
            current.previous = newNode;
            newNode.next = current;
        }
    }
}
