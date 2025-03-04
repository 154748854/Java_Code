package thread;

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("线程1");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Demo1 {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
    }
}
