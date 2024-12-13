package demo2;

abstract class Shape {
    public String name;
    public static int a;
    public void eat() {

    }
    public abstract void draw();
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}
public class DemoTest {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        drawMap(new Cycle());
        drawMap(new Rect());
    }
}
