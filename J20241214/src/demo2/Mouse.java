package demo2;

public class Mouse implements USB{
    @Override
    public void openDevice() {
        System.out.println("鼠标开始工作");
    }
    public void click() {
        System.out.println("疯狂点击鼠标");
    }
    @Override
    public void closeDevice() {
        System.out.println("鼠标结束工作");
    }
}
