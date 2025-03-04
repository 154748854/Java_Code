package thread;

public class Demo6 {
    public static void main(String[] args) {
        // Thread() 创建线程对象
        // Thread(Runnable t) 使用Runnable对象创建线程
        // Thread(String name) 创建线程并命名
        // Thread(Runnable t, String name)
        // 使用 Runnable 对象创建线程对象，并命名
        Thread t = new Thread(() -> {
           while (true) {
               System.out.println("hello");
           }
        },"新线程");
    }
}
