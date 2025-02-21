class Counter {
    public int count;
    synchronized public void increase() {
        count++;
    }
    public void increase2() {
        synchronized (this) {
            count++;
        }
    }
}

//synchronized使用方法
public class Demo14 {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50000; i++) {
                counter.increase();
            }
        });

        System.out.println(counter.count);
    }
}
