package com.ktb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class IOtest {


    public static void main(String[] args) throws UnsupportedEncodingException {
//        byte[] bytes = new byte[]{34, 56};
//        File file = new File("/Users/xiaohuge/IdeaProjects/java-camp/maven_jvm");
//        writeToFile(file, "text.txt",bytes);

        String strChinese = "大吉大利";
        byte[] bChinese_gbk = strChinese.getBytes("GBK"); //GBK编码格式
        byte[] bChinese_utf8 = strChinese.getBytes("UTF-8"); // UFT-8编码格式
        byte[] bChinese_iso88591 = strChinese.getBytes("ISO8859-1");

        System.out.println("bChinese_gbk = " + Arrays.toString(bChinese_gbk));
        System.out.println("bChinese_utf8 = " + Arrays.toString(bChinese_utf8));
        System.out.println("bChinese_iso88591 = " + Arrays.toString(bChinese_iso88591));



        String strChinese_gbk = new String(bChinese_gbk,"GBK");
        String strChinese_utf8 = new String(bChinese_utf8,"UTF-8");
        String strChinese_iso88591 = new String(bChinese_iso88591,"ISO8859-1");

        System.out.println("strChinese_gbk = " + strChinese_gbk);
        System.out.println("strChinese_utf8 = " + strChinese_utf8);
        System.out.println("strChinese_iso88591 = " + strChinese_iso88591);

    }

    private static void writeToFile(File outputDir, String filename, byte[] bytes) {
        try {
            File outFile = new File(outputDir, filename);
            if (outFile.exists()) {
                outFile.delete();
            }
            outFile.createNewFile();
            PrintWriter printWriter = new PrintWriter(new FileOutputStream(outFile));
            for (int j = 0; j < bytes.length; j++) {
                printWriter.print(Integer.toHexString(bytes[j] & 0xff));
                if (j < bytes.length - 1) {
                    printWriter.print("\n");
                }
            }
            printWriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
