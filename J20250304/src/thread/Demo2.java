package thread;

class MyRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
        }
    }
}
public class Demo2 {
    public static void main(String[] args) {
        Runnable runnable = new MyRunnable();
        Thread t = new Thread(runnable);
        t.start();
    }
}
