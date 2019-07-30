package eafit.edu.ds1.recursion;

public class Recursion{

    public static long sum(long n){

        if(n == 1){
            return n;
        }
        return n +sum(n-1);

    }

    public static long constSum(long n){
        return (n*(n+1))/2;
    }

    public static double factorial(double n){
        if(n == 1){
            return n;
        }
        return n * factorial(n-1);
    }

    public static long fib(long n){
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }
    public int increase(int n){
        return n++;
    }

    public int sumO1(int n){
        return n*(n+1)/2;
    }

    public static long iterFib (long n){
        long result = 0;
        long n_2 = 0;
        long n_1 = 1;

        long tempN2 = 0;
        long tempN1 = 1;
        for (int i = 2; i < n - 1; i++) {
            result = tempN1 + tempN2;
            tempN2 = tempN1;
            tempN1 = result;
        }
        n_2 = result;

        tempN2 = 0;
        tempN1 = 1;
        for (int i = 2; i < n; i++) {
            result = tempN1 + tempN2;
            tempN2 = tempN1;
            tempN1 = result;
        }
        n_1 = result;
        result = n_1 + n_2;
        return result;
    }

    public void count2(int n){
        int count = 1;
        while(count < n){
            count *= 2;
        }

    }

    public static long iterFib2(long n){
        long result = 0;
        long n_2 = 0;
        long n_1 = 1;
        for(int i = 2; i < n + 1; i++){
            result = n_1 + n_2;
            n_2 = n_1;
            n_1 = result;
        }

        return result;
    }


    public static void main(String []args){
        long initTime;
        initTime = System.nanoTime();
        System.out.println("Rec result: " + Recursion.fib(40) + " Time: " + (System.nanoTime() - initTime));
        initTime = System.nanoTime();
        System.out.println("Iter result: " +Recursion.iterFib(40) + " Time: " + (System.nanoTime() - initTime));
        initTime = System.nanoTime();
        System.out.println("Iter2 result: " +Recursion.iterFib2(40) + " Time: " + (System.nanoTime() - initTime));
    }
}
