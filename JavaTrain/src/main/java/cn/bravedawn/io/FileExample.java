package cn.bravedawn.io;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileExample {

    public static void main(String[] args) throws IOException {
        String fileName = "test.txt";
        createFile(fileName);

        deleteFile(fileName);

        useTempFile();

    }

    private static void createFile(String fileName) throws IOException {
        File file = new File(fileName);
        System.out.println(file.createNewFile());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getCanonicalPath());
        System.out.println(File.separator);
        System.out.println(File.separatorChar);
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.canExecute());
        System.out.println(file.length());
    }

    private static void deleteFile(String fileName){
        File file = new File(fileName);
        System.out.println(file.delete());
    }

    private static void useTempFile() throws IOException {
        File file = File.createTempFile("temp", "txt");
        System.out.println(file.getAbsolutePath());
        file.deleteOnExit();
    }

    private static void listFile(String path){
        File file = new File(path);


    }
}
