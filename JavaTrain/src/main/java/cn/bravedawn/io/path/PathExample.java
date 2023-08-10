package cn.bravedawn.io.path;

public class PathExample {

    /**
     * 获取当前项目的相关路径
     */

    public static void main(String[] args) {
        Class cls = PathExample.class;
        String projectPath = System.getProperty("user.dir"); // 当前项目工程的路径
        String classPath = cls.getResource("/").toString(); // 当前项目的classPath
        String classPath2 = cls.getClassLoader().getResource("").toString(); // 当前项目的classPath
        String classFullPath = cls.getResource("").toString(); // //获取当前类基于classPath的完整路径

        System.out.println(projectPath);
        System.out.println(classPath);
        System.out.println(classPath2);
        System.out.println(classFullPath);
    }
}
