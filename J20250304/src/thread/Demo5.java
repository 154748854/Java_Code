package thread;

public class Demo5 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while (true) {
               System.out.println("hello");
           }
        });
        t.start();
    }
}
