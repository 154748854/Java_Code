public class Demo19 {
    public static void main(String[] args) {
        Object object = new Object();
        synchronized (object) {
            System.out.println("wait之前");
            
        }
    }
}
