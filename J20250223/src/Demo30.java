import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Demo30 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> callable  = new Callable<Integer>() {
            // 定义了任务
            @Override
            public Integer call() throws Exception {
                int sum = 0;
                for (int i = 0; i <= 1000; i++) {
                    sum += i;
                }
                return sum;
            }
        };
        // 把任务放到线程中进行执行
        FutureTask<Integer> futureTask = new FutureTask<>(callable);
        Thread t = new Thread(futureTask);
        t.start();

        // 此处的get 就能获取到 callable 里面的返回结果
        // 由于线程是并发执行的,执行到主线程的 get 的时候,t 线程可能还没执行完
        // 没执行完也没事,get会阻塞
        System.out.println(futureTask.get());
    }
}
