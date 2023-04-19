package com.example.file;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//读取zip包里面的内容 当然还有把内容放大压缩包 这里就不写了
public class ZipDemo {


    public static void main(String[] args) throws IOException {

        ZipOutputStream out = new ZipOutputStream(new FileOutputStream("./a.zip"));
        File[] files = {new File("/Users/xioahuge/IdeaProjects/java-camp/juc-demo/src/main/resources/application.properties")};
        for (File f : files) {
//            每条zip文件的文件名
            out.putNextEntry(new ZipEntry(f.getName()));
            System.out.println(f.toPath());
            out.write(Files.readAllBytes(f.toPath()));
//            写进一个文件关闭一个文件
            out.closeEntry();
        }
        out.close();



//        try (ZipInputStream zip = new ZipInputStream(new FileInputStream("/Users/xioahuge/IdeaProjects/java-camp/juc-demo/src/main/resources/application.properties.zip"))) {
//            ZipEntry entry = null;
//            while ((entry = zip.getNextEntry()) != null) {
//                String name = entry.getName();
//                if (!entry.isDirectory()) {
//                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                    byte[] buffer = new byte[1024];
//                    int n;
//                    while ((n = zip.read(buffer)) != -1) {
//                        byteArrayOutputStream.write(buffer, 0, n);
//                    }
//                    byte[] bytes = byteArrayOutputStream.toByteArray();
//                    String s = new String(bytes);
//                    System.out.println("s = " + s);
//                } else {
//                }
//                zip.closeEntry();
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
