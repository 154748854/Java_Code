interface IRun {
    void run();
}
interface Iswim {
    void swim();
}
interface IAmphibious extends IRun, Iswim {

}
class Frog implements IAmphibious {
    @Override
    public void run() {

    }

    @Override
    public void swim() {

    }
}
public class Test {
}
