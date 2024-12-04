public class Test {
    public static int[] fib(int n){
        if(n <= 0){
            return null;
        }
        int[] array = new int[n];//这里n是数组元素的个数
        array[0] = array[1] = 1;
        for(int i = 2; i < n; i++){//这里注意i是数组元素的下标。i=2就是第3项
            array[i] = array[i-1] + array[i-2];
        }

        return array;
    }
   public static void main(String[] args) {
        int[] array = fib(2);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    /*public static void main(String[] args) {
       int[] array = fib(10);
       for (int i = 0; i < array.length; i++) {
           System.out.println(array[i]);
       }
   }*/
    /*public static int[] fib1(int n) {
        if (n <= 0) {
            return null;
        }
        int[] array = new int[n];
        array[0] = array[1] = 1;
        for (int i = 2; i < n; ++i) {
            array[i] = array[i-1] + array[i-2];
        }

     *//*   return array;
    }*//*
    public static void main2(String[] args) {
        int[] array1 = new int[]{1,2,3};
        int[] array2 = new int[]{10,20,30};
        array1 = array2;
        array1[0] = 100;
        array2[1] = 200;
        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);//100 200 30
        }*/
    //}
    public static void main1(String[] args) {
        int[] array1 =new int[10];
        //int[] 引用了一个变量叫array1，该对象指向一个数组new int[10]
        //array1变量中存储的是他所指向对象的起始地址
        for (int x:array1) {
            System.out.print(x+" ");
        }
        System.out.println(array1);
    }
}
