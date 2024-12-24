package demo;

public interface USB {
    void openDevice();//这里的隐式是public，并不是default
    void closeDevice();
}
