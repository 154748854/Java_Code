public class Demo19 {
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait之前");
            // 把wait要放到synchronized里面来调用,保证确实是拿到了锁
            object.wait();
            // 这里wait之后就会一直等待下去,这个时候就是用到了另一个唤醒方法notify
            System.out.println("wait之后");
        }
    }
}
