class Alg<T extends Comparable<T>> {
    public T findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0) max = array[i];
        }
        return max;
    }
}
class Alg2 {
    //泛型方法
    /*public <T extends Comparable<T>> findMax(T[] array) {
        T max = array[0];
        for (int i = 0; i < array.length; i++) {
            if(max.compareTo(array[i]) < 0) max = array[i];
        }
        return max;
    }*/
}
public class Test {
    public static void main(String[] args) {
        Alg<Integer> alg = new Alg<>();
    }
}
