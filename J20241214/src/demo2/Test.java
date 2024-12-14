package demo2;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerOn();
        Mouse mouse = new Mouse();
        computer.useService(mouse);
        computer.powerOff();
    }
}
