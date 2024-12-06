import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = new int[2][];
        array[0] = new int[]{1,2};
        array[1] = new int[]{3,4,5};
        System.out.println(Arrays.deepToString(array));

    }
    public static void main4(String[] args) {
        //int[][] array = new int[2][3];
        //int[][] array2 = {{1,2,3},{4,5,6}};
        int[][] array1 = new int[][]{{1,2,3,},{4,5,6}};
        for (int[] tmp:array1) {
            for (int x:tmp) {
                System.out.print(x+" ");
            }
            System.out.println();
        }

    }
    public static void main3(String[] args) {
        int[] array = new int[]{1,2,3};
        int[] array1 = Arrays.copyOf(array, array.length+5);//该方法返回值是一个数组
        System.out.println(Arrays.toString(array1));
    }

    public static void main1(String[] args) {
        hanio(1,'A','B','C');
    }
    public static void move(char pos1,char pos2) {//显示移动路径
        System.out.println(pos1+" => "+pos2+" ");
    }
    public static void hanio(int n,char pos1,char pos2,char pos3) {//这里的pos1是初始位置，pos2是中专位置，pos3是目的地
        if(n == 1) {
            move(pos1,pos3);
            return;
        }
        hanio(n-1,pos1,pos3,pos2);
        move(pos1,pos3);
        hanio(n-1,pos2,pos1,pos3);
    }

}
