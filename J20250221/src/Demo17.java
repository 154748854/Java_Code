import java.util.Scanner;

public class Demo17 {
    private static volatile int isQuit = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           while (isQuit == 0) {
               // 循环体里啥都没干
               // 此时意味着这个循环,一秒钟就会执行很多次
           }
            System.out.println("t1 退出!");
        });
        t1.start();

        Thread t2 = new Thread(() -> {
            System.out.println("请输入isQuit: ");
            Scanner scanner = new Scanner(System.in);
            //一旦用户输入的值,不为0,此时就会使t1 线程执行结束
            isQuit = scanner.nextInt();
        });
        t2.start();
    }
}
