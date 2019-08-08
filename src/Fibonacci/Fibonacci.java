package Fibonacci;

public class Fibonacci {
    public static void main(String[] args){

        Fibonacci fibonacci = new Fibonacci();

//        for(int i = 0; i < 10 ; i++){
//            System.out.println(fibonacci.FibonacciNumber(i));
//
//            //System.out.println(fibonacci.fib(i));
//        }


        fibonacci.printArray(fibonacci.fibWithArray(10));
    }

    public int FibonacciNumber(int n){

        if(n < 2){
            return n;
        }

        int f1 = 1;
        int f2 = 0;
        int result = 0;
        for(int i = 2; i <= n; i++){
             result = f1 + f2;
             f2 = f1;
             f1 = result;
        }

        return result;
    }

    public int fib(int n){

        if(n < 2){
            return n;
        }

        return fib(n - 1) + fib(n - 2);
    }

    public int[] fibWithArray(int n){
        int f[] = new int[n + 1];
        int i;

        f[0] = 0;
        f[1] = 1;

        for(i = 2; i <= n; i++){
            f[i] = f[i-1] + f[i-2];
        }

        return f;
    }

    public void printArray(int[] arr){

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}
