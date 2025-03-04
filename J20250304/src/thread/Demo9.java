package thread;

public class Demo9 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted())
            // 在Thread内部,其实有一个现成的标志位,
            // 可以用来判定当前的循环是否要结束
            {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });
        t.start();

        Thread.sleep(5000);
        System.out.println("让t线程终止");
        t.interrupt();
    }
}
