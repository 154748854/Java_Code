package thread;

public class Demo3 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello");
                }
            }
        };
        t.start();
    }
}
