import java.nio.charset.IllegalCharsetNameException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("|          |   10   |    20    |    30    |    40     |      50         |");
        System.out.print("|   Naive  |");
        for(int i = 10; i<=51; i+=10){
            long startTime = System.nanoTime();
            naiveFib(i);
            long elapsedTime = System.nanoTime() - startTime;
            if (i <= 30) {
                System.out.print("  " + elapsedTime + "  |");
            }
            if(i>30)
            {
                System.out.print("  " + elapsedTime + " |");
            }

        }

        System.out.print("\n| recursive|");
        for(int i = 10; i<=51; i+=10){
            long startTime = System.nanoTime();
            memoFib(i);
            long elapsedTime = System.nanoTime() - startTime;
            if(i > 20){
                System.out.print("  ");
                if(i>30){
                    System.out.print(" ");
                }
            }
            System.out.print("  " + elapsedTime + "  |");

        }

        System.out.print("\n| bottom-up|");
        for(int i = 10; i<=51; i+=10){
            long startTime = System.nanoTime();
            bottomUpFib(i);
            long elapsedTime = System.nanoTime() - startTime;
            if(i > 20)
            {
                System.out.print("  ");
                if(i>30){
                    System.out.print(" ");
                }
            }
            System.out.print("  " + elapsedTime + "   |");
        }

    }

    private static double naiveFib(double n) {
        double f;
        if (n <= 2) {
            return 1.0;
        } else {
            f = naiveFib(n - 1) + naiveFib(n - 2);
            return f;
        }
    }


    private static Map<Double, Double> memoTable = new HashMap<>();

        private static double memoFib(double n) {
            int[] fib = new int[(int)n+1];
            double f;
            if (memoTable.containsKey(n)) {
                return memoTable.get(n);
            }
            if (n <= 2) {
                return 1;
            }
            else {
                f = memoFib(n - 1) + memoFib(n - 2);
                memoTable.put(n, f);
                return f;
            }
        }



        private static double bottomUpFib(double n) {
            int[] fib = new int[(int)n+1];
            int f = 0;

            for (double k = 1; k <= n; k++ ) {
                if (k <=2 ) {
                    fib[(int)k] = 1;
                }
                else {
                    f = fib[(int)k-1] + fib[(int)k-2];
                    fib[(int)k] = f;
                }
            }
            return f;
        }
}
