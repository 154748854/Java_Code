package thread;

public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();


        System.out.println("main线程等待中");
        t.join();
        // 一旦调用join方法,主线程就会阻塞,此时t线程会继续执行
        // 一直到t线程执行结束了,join才会解除阻塞
        System.out.println("main线程等待结束");
    }
}
