package lesson_1;

public class HW_1 {
    public static void main(String[] args) {
        System.out.println(pow(2, 7));
        System.out.println(pow2(2, 7));
        System.out.println(sumSeriesNumbers(1, 100));
    }

    public static double pow(double basis, int degree){
        if (degree == 0){
            return 1.0;
        }
        if (basis == 0){
            return 0;
        }
        double result = basis;
        for (int i = 1; i < degree; i++) {
            result *= basis;
        }
        return result;
    }

    public static double pow2(double basis, int degree){
        double result = 1.0;

        if (basis == 0){
            return 0;
        }
        while(degree != 0){
            if (degree % 2 != 0){
                degree -= 1;
                result *= basis;
            } else {
                degree /= 2;
                basis *= basis;
            }
        }
        return result;
    }

    public static int sumSeriesNumbers(int begin, int end){
        int result = 0;
        if (begin > end){
            int temp = begin;
            begin = end;
            end = temp;
        }
        for (int i = begin; i <= end; i++) {
            result += i;
        }
        return result;
    }
}
