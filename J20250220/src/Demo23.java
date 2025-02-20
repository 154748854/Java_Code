import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Demo23 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        queue.put("111");
        queue.put("222");
        queue.put("333");
        queue.put("555");
        String elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
        elem = queue.take();
        System.out.println(elem);
    }
}
