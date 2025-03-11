class Counter {
    public int count = 0;

    synchronized public void increase() {
        // 1. 修饰普通方法:锁的Counter对象
        count++;
    }

    public void increase2() {
        synchronized (this) {
            // 2. 明确指定锁那个对象:锁当前对象
        }
    }
    synchronized public static void increase3() {
        // 3. 修饰静态方法: 锁的Counter类对象
    }

    public static void increase4() {
        synchronized (Counter.class) {
            // 4. 明确指定锁那个对象: 锁类对象
        }
    }


}

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Counter count = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.increase();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                count.increase();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(count.count);
    }
}
