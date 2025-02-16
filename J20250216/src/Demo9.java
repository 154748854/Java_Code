//线程终止
public class Demo9 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while (!Thread.currentThread().isInterrupted()) {

           }
        });
        t.start();
    }
}
