public class Demo20 {
    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (object) {
                System.out.println("执行之前");
                try {
                    object.wait();
                    //1. 释放当前的锁
                    //2. 让线程进入阻塞
                    //3. 当线程被唤醒的时候，重新获取锁
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行之后");
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (object) {
                System.out.println("进行通知");
                // 进行通知后,才会打印线程1中的 "执行之后"
                object.notify();
            }
        });
        t1.start();
        t2.start();
    }
}
