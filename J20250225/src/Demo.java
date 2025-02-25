public class Demo {
    public static void main(String[] args) {
        // 创建线程对象
        Thread t1 = new Thread();
        //使用Runnable对象创建Thread对象
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        
    }
}
