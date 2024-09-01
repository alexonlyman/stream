package alex_group.model;

import java.util.concurrent.RecursiveTask;

public class FactorialTask extends RecursiveTask<Long> {
    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    protected Long compute() {

        if (number <= 1) {
            return 1L;
        }

        int middle = number / 2;
        FactorialTask lowerTask = new FactorialTask(number - middle);
        FactorialTask upperTask = new FactorialTask(middle);

        lowerTask.fork();
        upperTask.fork();

        long upperResult = upperTask.join();
        long lowerResult = lowerTask.join();
        return upperResult * lowerResult;
    }
}
