public class Demo12 {
    private static int count = 0;
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count++;
            }
        });


        t1.start();
        t2.start();

        t1.join();
        t2.join();
        // 等待两个线程全部执行完毕

        // 我们预期的结果是10W,但是实际上的结果一般是小于10W的
        // 并且每次执行的结果都不一样
        System.out.println("count:"+count);

    }
    public static void main1(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.getState());
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(t.getState());
            Thread.sleep(1000);
        }

        t.join();
        System.out.println(t.getState());
    }
}
