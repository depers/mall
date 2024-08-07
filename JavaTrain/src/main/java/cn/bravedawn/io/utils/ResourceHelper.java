package cn.bravedawn.io.utils;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : JavaTrain
 * @description:
 * @date : Created in 2023/2/7 17:49
 */
public class ResourceHelper {

    /**
     * 获取编译后resources下文件的路径
     */

    public static String getAbsoluteFilePath(String filename) {
        URL resource = ClassLoader.getSystemClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File: " + filename + " not found.");
        }

        try {
            Path path = Paths.get(resource.toURI());
            return path.toString();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
