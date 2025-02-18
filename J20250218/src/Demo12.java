public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
           while (true) {
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        });
        //在调用start之前获取装台，此时就是NEW状态
        System.out.println(t.getState());
        t.start();

        for (int i = 0; i < 5; i++) {
            System.out.println(t.getState());
            Thread.sleep(1000);
        }
        //在线程结束之后，获取线程状态此时就是TERMINATE状态

        t.join();
        System.out.println(t.getState());
    }
}
