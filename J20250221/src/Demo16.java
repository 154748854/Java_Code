public class Demo16 {
    private static Object locker1 = new Object();
    private static Object locker2 = new Object();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
           synchronized (locker1) {
               //此处的sleep很重要,要确保t1 和 t2 都要跟别拿到一把锁之后,再进行后续动作
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }

               synchronized (locker2) {
                   System.out.println(" t1 加锁成功");
               }
           }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (locker2) {
                System.out.println(111);
            }


        });
    }
}
