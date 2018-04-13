package by.dm13y.sketch.concurrency.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CompletableFutureExamples {

    public void runAsyncRunnable(Runnable runnable){
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable);
    }

    public void runAsyncSupplierVoid(Supplier<Void> supplier){
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(supplier);
    }

    public void runAsyncSupplierInteger(Supplier<String> supplier, Consumer<String> consumer, Consumer<Void> consumer1, Function<Throwable, Void> exception){
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(supplier);
        completableFuture
                .thenAccept(consumer)
                .thenAccept(consumer1)
                .exceptionally(exception);
    }


}
