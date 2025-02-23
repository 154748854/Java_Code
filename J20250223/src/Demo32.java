

import java.util.concurrent.CountDownLatch;

public class Demo32 {
    public static void main(String[] args) throws InterruptedException {
        // 当前有是个选手参赛
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int id = i;
            Thread t = new Thread(() -> {
                System.out.println("Thread+"+id);
                // 通知当前的任务已经执行完毕了
                countDownLatch.countDown();
            });
            t.start();
        }
        countDownLatch.await();
        System.out.println("所有任务已完成");
    }
}
