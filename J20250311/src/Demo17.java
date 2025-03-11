import java.util.Scanner;

public class Demo17 {
    public static volatile int isQuit = 0;
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (isQuit == 0) {
                // do nothing
            }
            System.out.println("线程1结束");
        });

        t1.start();

        Thread t2 = new Thread(() -> {
           Scanner scanner = new Scanner(System.in);
           isQuit = scanner.nextInt();
        });
        t2.start();
        // 当我们输入0的时候,线程并不会结束,谪显然是一个bug
    }
}
