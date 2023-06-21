package cn.bravedawn.java8.lambdaexpressions.effectivelyfinal;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.stream.IntStream;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/5/24 13:44
 */
public class Test {

    private int start = 0;
    private volatile boolean run = true;

    private ExecutorService executor = Executors.newFixedThreadPool(3);


    public static void main(String[] args) {

    }

    Supplier<Integer> incrementer() {
        return () -> start++;
    }

    public void instanceVariableMultithreading() {
        executor.execute(() -> {
            while (run) {
                // do operation
            }
        });

        run = false;
    }

    public static int workaroundSingleThread() {
        int[] holder = new int[] { 2 };
        IntStream sums = IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0]);

        holder[0] = 0;

        return sums.sum();
    }

    public static void workaroundMultithreading() {
        int[] holder = new int[] { 2 };
        Runnable runnable = () -> System.out.println(IntStream
                .of(1, 2, 3)
                .map(val -> val + holder[0])
                .sum());

        new Thread(runnable).start();

        // simulating some processing
        // try {
        //     Thread.sleep(new Random().nextInt(3) * 1000L);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }

        System.out.println("方法线程执行完毕");
        holder[0] = 0;
    }

    //
    // public void localVariableMultithreading() {
    //     boolean run = true;
    //     executor.execute(() -> {
    //         while (run) {
    //             // do operation
    //         }
    //     });
    //
    //     run = false;
    // }


}
