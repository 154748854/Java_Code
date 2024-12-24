package demo;

public class Computer {
    public void powerOn() {
        System.out.println("打开笔记本");
    }
    public void powerOff() {
        System.out.println("关闭笔记本");
    }
    public void usbDevice(USB usb) {
        usb.openDevice();
        if(usb instanceof Mouse) {
            Mouse mouse = (Mouse)usb;
            mouse.click();
        }else if(usb instanceof keyBoard) {
            keyBoard keyBoard = (keyBoard) usb;
            keyBoard.input();
        }
        usb.closeDevice();
    }
}
