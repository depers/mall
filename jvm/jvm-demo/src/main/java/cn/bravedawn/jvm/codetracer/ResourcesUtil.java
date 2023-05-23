package cn.bravedawn.jvm.codetracer;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author : depers
 * @program : jvm-demo
 * @description:
 * @date : Created in 2023/5/23 11:22
 */
public class ResourcesUtil {

    public static String getAbsoluteFilePath(String filename) {
        URL resource = ClassLoader.getSystemClassLoader().getResource(filename);
        if (resource == null) {
            throw new IllegalArgumentException("File: " + filename + " not found.");
        }

        try {
            Path path = Paths.get(resource.toURI());
            System.out.println(path.toString());
            return path.toString();
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
