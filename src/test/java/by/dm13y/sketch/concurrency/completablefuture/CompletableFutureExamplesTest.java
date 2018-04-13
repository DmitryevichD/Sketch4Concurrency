package by.dm13y.sketch.concurrency.completablefuture;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.Assert.*;

public class CompletableFutureExamplesTest {
    private final CompletableFutureExamples examples = new CompletableFutureExamples();
    @Test
    public void runAsyncRunnable() throws Exception {
        examples.runAsyncRunnable(() -> {System.out.println("Use runnable");});
    }

    @Test
    public void runAsyncSupplierVoid() throws Exception {
        examples.runAsyncSupplierVoid(() -> {System.out.println("Use supplier");
        return null;
        });
    }

    @Test
    public void runAsyncSupplierInteger() throws Exception {
        Supplier<String> supplier = () -> {return "supplier_args_to_consumer";};
        Consumer<String> consumer = s -> System.out.println("exec_consumer_with_arg" + s);
        Consumer<Void> consumer1 = aVoid -> {throw new RuntimeException("Consumer do not return value, then exception");};
        Function<Throwable, Void> exception = throwable -> {
            System.out.println("start_exception");; return null;};

        examples.runAsyncSupplierInteger(supplier, consumer, consumer1, exception);
    }

}