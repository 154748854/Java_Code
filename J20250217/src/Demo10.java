public class Demo10 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("线程工作中");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t.start();

        //让主线程来等待t线程执行完毕
        //一旦调用join，主线程就会触发阻塞，此时t线程就能完成后续工作
        //一旦阻塞到t线程执行完毕，join才会解除阻塞，才能继续执行
        t.join();
        System.out.println("join");
    }
}
