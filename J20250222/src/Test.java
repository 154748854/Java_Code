class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("这里是线程写线程要运行的代码");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("这里是线程要执行的代码");
    }
}
public class Test {
    public static void main(String[] args) {
        Thread t3 = new Thread(() -> {
            System.out.println("使用lambda表达式");
        });
        t3.start();
    }
    public static void main4(String[] args) {
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类");
            }
        });
        t2.start();
    }
    public static void main3(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类");
            }
        };
        t1.start();
    }
    public static void main2(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
    }
    public static void main1(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
    }
}
