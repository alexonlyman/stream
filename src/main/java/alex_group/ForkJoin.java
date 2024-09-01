package alex_group;

import alex_group.model.FactorialTask;

import java.util.concurrent.ForkJoinPool;

public class ForkJoin {
    public static void main(String[] args) {
        int number = 10;

        ForkJoinPool pool = new ForkJoinPool();

        FactorialTask task = new FactorialTask(number);

        long result = pool.invoke(task);

        System.out.println("Factorial of " + number + " is " + result);

        pool.shutdown();
    }
}
