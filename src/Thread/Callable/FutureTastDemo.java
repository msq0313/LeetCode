package Thread.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
// 对子任务返回值的处理
public class FutureTastDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> task = new FutureTask<String>(new MyCallable());
        new Thread(task).start();
        if (!task.isDone()) {
            System.out.println("task has not finished, please wait!");
        }
        System.out.println(task.get());
    }
}
