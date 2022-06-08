package lesson_5;

public class Main {

    public static void main(String[] args) {
        System.out.println(pow(2, 10));
    }

    public static int pow(int base, int degree) {
        if (degree == 0) {
            return 1;
        }
        if (degree > 1) {
            base *= pow(base, --degree);
        }
        return base;
    }
}
