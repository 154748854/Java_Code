public class Demo7 {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("线程开始");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("线程结束");
        });
        t.start();
        System.out.println(t.isAlive());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(t.isAlive());
    }
}
