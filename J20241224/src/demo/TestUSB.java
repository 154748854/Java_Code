package demo;

public class TestUSB {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        computer.usbDevice(new Mouse());
        computer.powerOff();
    }
}
