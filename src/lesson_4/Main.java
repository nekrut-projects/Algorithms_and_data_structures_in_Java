package lesson_4;

public class Main {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.addFirst(new Cat("Cat__5", 5));
        list.addFirst(new Cat("Cat__4", 4));
        list.addFirst(new Cat("Cat__3", 3));
        list.addFirst(new Cat("Cat__2", 2));
        list.addFirst(new Cat("Cat__1", 1));
        list.addLast(new Cat("Cat__6", 6));
        list.addLast(new Cat("Cat__7", 7));
        list.addFirst(new Cat("Cat__0", 0));
        list.addLast(new Cat("Cat__8", 8));

        System.out.println(list);

        System.out.println(list.isContains(new Cat("Cat__1", 1)));

        list.remove(new Cat("Cat__5", 5));

        System.out.println(list);

        System.out.println(list.getIterator().atBegin());
        System.out.println(list.getIterator().atEnd());

        list.getIterator().deleteCurrent();

        list.getIterator().next();
        list.getIterator().next();
        list.getIterator().next();

        System.out.println(list.getIterator().getCurrent());

        list.getIterator().deleteCurrent();

        System.out.println(list);


        list.getIterator().insertAfter(new Cat("Cat__9", 9));
        list.getIterator().insertBefore(new Cat("Cat__0", 0));

        System.out.println(list);

        System.out.println(list.getIterator().getCurrent());

        list.getIterator().previous();

        System.out.println(list.getIterator().getCurrent());

    }
}
