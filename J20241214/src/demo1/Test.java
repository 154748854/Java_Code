package demo1;

/*class Date {
    public int year;

    public void setYear(int year) {
        this.year = year;
        System.out.println(this.year);
    }
    public Date() {
        this(2024);
    }

    public Date(int year) {
        this.year = year;
    }
}*/
/*class Date {
    public static int year;
    static {
       year = 2024;
        System.out.println(year);
    }

}*/
 /* public static void main(String[] args) {
        Date y = new Date();
        y.setYear(2024);
    }*/
interface Shape {
   /* public int a = 1;
    public static int b = 2;
    public static final int c = 3;*/
    /*
    int A = 1;
    int B = 2;
    int C = 3;
     */
    void draw();
}
class Rect implements Shape {
    @Override
    public void draw() {
        System.out.println("矩形！");
    }
}
class Flower implements Shape {
    @Override
    public void draw() {
        System.out.println("❀");
    }
}
public class Test {
    public static void drawMap(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        Shape shape1 = new Rect();
        Shape shape2 = new Flower();

        drawMap(shape1);
        drawMap(shape2);
        System.out.println("===========");

        Shape[] shapes = new Shape[]{new Rect(),new Flower(),new Flower(),new Flower()};
        for(Shape shape:shapes) {
            shape.draw();
        }
    }
}
