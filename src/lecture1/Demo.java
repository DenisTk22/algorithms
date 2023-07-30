package lecture1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class Demo {

//    public static void main(String[] args) {
//        List<Integer> availableDivider =  findAvlDiv(12);
//        for (Integer integer : availableDivider) {
//            System.out.println(integer);
//        }
//    }

    public static void main(String[] args) {
       // List<Integer> availableDivider =  findSimpleNumbers(6);
//        for (Integer integer : availableDivider) {
//            System.out.println(integer);
//        }
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(12, counter);
        System.out.println("Fibonachi: " + fib);
        System.out.println("Counter: " + counter.get());
    }

    // нахождение делителя числа
    public static List<Integer> findAvlDiv(int number) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                result.add(i);
            }
        }
        return result;
    }

    // нахождение простого числа
    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                counter ++; // counter = counter + 1
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }

    //поиск шанса выпадения определенной суммы на игральных кубиках (для 3х шестигранных кубиков)
    public static double findSum(int sum) {
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (i + j + k == sum) {
                        successResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) successResult) / ((double) count);
    }

    //Функция вычисления чисел Фибоначчи
    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet(); // счетчик
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }

    public static int fiboo(int chislo) {
        List<Integer> result = new ArrayList<>();
        int f = 1;
        for (int i = 0; i < chislo; i++){

        }
        return f;
    }

    public static int fibo(int number){
        if (number == 1 || number ==2) {return 1;}
        int first = 1;
        int second = 1;
        int count = 2;
        int save = 0;
        while (count < number){
            count ++;
            save = first;
            first = second;
            second = save + first;
        }
        return second;
    }
// Фибоначчи
    public class task5 {
        public static int fb(int num) {
            if (num <= 2)
                return 1;
            final int[] numbers = new int[num];
            numbers[0] = 1;
            numbers[1] = 1;
            for (int i = 2; i < numbers.length; i++) {
                numbers[i] = numbers[i - 1] + numbers[i - 2];
            }
            return numbers[num - 1];
        }
    }
}
