package io;

import java.io.File;
import java.io.IOException;

public class Demo2 {
    public static void main(String[] args) throws IOException {
        File file = new File("d:/test.txt");
        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());

        // 创建文件
         boolean bool = file.createNewFile();
        System.out.println(bool);

        System.out.println(file.exists());
        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
    }
}
