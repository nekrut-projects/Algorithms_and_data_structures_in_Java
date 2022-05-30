package lesson_2;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(new int[]{1,21,3,9,4,5,6,7,3,5,11,1,2,4,8,9,10,5,1,4,5,6,7,8,9,10,5,13,5,18,61,2,4,8});
        MyArray a = new MyArray(new int[]{3,5,1,1,2,42,8,3,8,4});

//        for (int i = 0; i < 500; i++) {
//            a.append(arr);
//        }

        a.display();
//        a.sortCounting();
        a.sortBubble2();
        a.display();
        System.out.println(a.isSortedArray());

    }
}
