package thread;
//创建线程
//创建一个类，继承Thread Thread 来自标准库
class MyThread extends Thread {
    @Override
    public void run() {
        //  这个方法就是线程的入口方法；
        System.out.println("hello thread");
    }
}
public class Demo1 {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}
//还学了sql的联合查询，但是sql导出sql文件好麻烦，干脆不传sql了