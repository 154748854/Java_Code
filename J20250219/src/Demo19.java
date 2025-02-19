public class Demo19{
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait之前");
            // 把wait 要放到 synchronized 里面,保证确实是拿到了锁,才能够去进行释放锁
            object.wait();
            System.out.println("wait之后");
        }
    }
}
