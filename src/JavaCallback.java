import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;
import java.util.function.Function;

public class JavaCallback {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> task = () -> {
            Thread.sleep(2000);
            return "hell owlrd";
        };
//        System.out.println("here");
        FutureTask problem = new FutureTask(task);
//        new Thread(problem).start();
//
//        Object o =  problem.get();
//        System.out.println(o.toString());
//        AtomicLong longValue = new AtomicLong(0);
//        Runnable task = () -> longValue.set(new Date().getTime());
//        Function<Long, Date> dateConverter = Date::new;
//        Consumer<Date> printer = System.out::println;
        // CompletableFuture computation
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(problem);
//        System.out.println(voidCompletableFuture.get());
//        System.out.println("start");
//        Thread.sleep(4000);
        CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
                throw new NullPointerException();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "hwl";
        }).thenAccept(System.out::println)
                .exceptionally((e) -> {
                    System.out.println("oops");
                    return null;
                });
        System.out.println("end");
        Thread.sleep(4000);
    }
}
