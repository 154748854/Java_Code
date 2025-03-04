package thread;

public class Demo8 {
    private static boolean isQuit = false;

    public static void main(String[] args) throws InterruptedException {
       // boolean isQuit = false;
        Thread t = new Thread(() -> {
           while (!isQuit) {
               System.out.println("线程工作中");
           }
            System.out.println("线程工作完毕");
        });

        t.start();
        Thread.sleep(5000);

        isQuit = true;
        System.out.println("设置 isQuit为true");
    }
}
