package Thread.Callable;

import java.util.concurrent.Callable;

public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        String value = "test";
        System.out.println("Ready to work");
        Thread.currentThread().sleep(3000);
        System.out.println("task done");
        return value;
    }
}
