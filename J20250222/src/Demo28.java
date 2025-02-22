import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class MyThreadPool {
    // 任务队列
    private BlockingQueue<Runnable> queue = new ArrayBlockingQueue<>(4);

    // 通过这个方法把任务添加到队列中
    public void submit(Runnable runnable) throws InterruptedException {
        // 此处咋们的拒绝策略,相当于是第五种拒绝策略,直接阻塞等待(这是一个下策
        queue.put(runnable);
    }

    public MyThreadPool(int n) {
        // 创建出 n 个线程负责执行上述队列中的任务
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
               // 让这个线程,从队列中消费任务,并去执行
                try {
                    Runnable runnable = queue.take();
                    runnable.run();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
public class Demo28 {
    public static void main(String[] args) throws InterruptedException {
        MyThreadPool myThreadPool = new MyThreadPool(4);
        for (int i = 0; i < 1000; i++) {
            // 每次循环都是创建了一个新的id
            int id = i;
            myThreadPool.submit(new Runnable() {
                //  i 是在匿名内部类中的.捕获了外部类中的变量i
                @Override
                public void run() {
                    System.out.println("执行任务"+id);
                    // 此时捕获的是id不是i了,id没有人修改
                }
            });
        }
    }
}
