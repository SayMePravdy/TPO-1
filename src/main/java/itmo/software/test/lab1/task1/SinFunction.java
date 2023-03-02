package itmo.software.test.lab1.task1;

public class SinFunction {

    private static final int CNT = 100;

    public static double calc(double x) {

        double PI2 = Math.PI * 2;

        x -= (int) (x / PI2) * PI2; // to range from 0 to 2Pi

//        ugly variant
//        if (x >= 0) {
//            while (x > PI2) {
//                x -= PI2;
//            }
//        } else {
//            while (x < PI2) {
//                x += PI2;
//            }
//        }


        double result = 0;

        double xx = x * x;
        double pow = x;
        double fact = 1;

        int sign = 1;

        for (int i = 1; i < CNT; i += 2) {
            fact /= i;
            result += sign * pow * fact;    // (-1)^(n-1) * x^(2n-1) / (2n-1)!
            sign *= -1;
            fact /= (i + 1);
            pow *= xx;
        }

        return result;
    }
}
