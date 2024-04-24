package cn.bravedawn.io.file.readfile;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/8 22:11
 */
public class ReadFile5c {

    /**
     * 使用BufferedReader该方式需要手动通过try-catch-finally进行资源的关闭
     */
    public static void main(String[] args) {
        String fileName = ResourceHelper.getAbsoluteFilePath("doc/test.txt");

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(fileName);
            br = new BufferedReader(fr);

            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();
            } catch (IOException ex) {
                System.err.format("IOException: %s%n", ex);
            }
        }
    }
}
