public class Demo9 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
           while (!Thread.currentThread().isInterrupted()) {
               System.out.println("线程工作中");
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   //1. 不做处理，假装没听见
                   e.printStackTrace();
                   //2. break;立即中断
                   //break;

                   //3. 做一些其他工作，完成后再break；
                   System.out.println("你好");
                   break;
               }
           }
        });
        t.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("让t线程终止");
        t.interrupt();
    }
}
