package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello");
        }
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
    }
}
