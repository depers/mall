package cn.bravedawn.io.path;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-11-08 15:34
 */
public class ManageFilesAndDirectories {

    /**
     * 映射功能：管理文件和目录
     */


    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        File file = new File("");

        // 创建文件
        boolean result = file.createNewFile();
        Path newPath = Files.createFile(path);

        // 创建目录
        boolean result2 = file.mkdir();
        Path newPath2 = Files.createDirectory(path);

        // 创建目录（包含不存在的子目录）
        boolean result3 = file.mkdirs();
        Path newPath3 = Files.createDirectories(path);


        // 重命名或移动文件
        boolean result4 = file.renameTo(new File("baeldung/tutorial2.txt"));
        Path newPath4 = Files.move(path, Paths.get("baeldung/tutorial2.txt"));

        // 删除操作
        boolean result5 = file.delete();
        Files.delete(path);

    }
}
