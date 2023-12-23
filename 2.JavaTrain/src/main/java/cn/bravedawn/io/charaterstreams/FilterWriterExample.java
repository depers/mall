package cn.bravedawn.io.charaterstreams;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.*;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 16:01
 */
public class FilterWriterExample {

    /**
     * FilterWriter 类是一个抽象类，用于编写过滤后的字符流。
     * FilterWriter 的子类应重写其某些方法，并且还可以提供其他方法和字段。
     */

    static class CustomFilterWriter extends FilterWriter {
        CustomFilterWriter(Writer out) {
            super(out);
        }

        public void write(String str) throws IOException {
            super.write(str.toLowerCase());
        }
    }


    public static void main(String[] args) {
        try {
            String inputPath = ResourceHelper.getAbsoluteFilePath("doc/input.txt");
            FileWriter fw = new FileWriter(inputPath);
            CustomFilterWriter filterWriter = new CustomFilterWriter(fw);
            filterWriter.write("I LOVE MY COUNTRY");
            filterWriter.close();

            FileReader fr = new FileReader(inputPath);
            BufferedReader bufferedReader = new BufferedReader(fr);
            int k;
            while ((k = bufferedReader.read()) != -1) {
                System.out.print((char) k);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
