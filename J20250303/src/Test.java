class MyRunnable {
    public static boolean isQuit = false;
    Thread t = new Thread(() -> {
        while (!isQuit) {
            System.out.println("hello");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    });

}

public class Test {
}
