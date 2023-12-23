package cn.bravedawn.io.file.filepermission;

import java.io.FilePermission;
import java.io.IOException;
import java.security.PermissionCollection;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-18 10:52
 */
public class FilePermissionExample2 {

    /**
     * Java FilePermission 类包含与目录或文件相关的权限。所有权限都与路径相关。
     * 路径有两种类型：
     * 1、D:\\IO\\-：表示权限递归关联所有子目录和文件。
     * 2、D:\\IO\\*：表示权限与该目录下的所有目录和文件相关联，不包括子目录。
     */


    public static void main(String[] args) throws IOException {
        String srg = "D:\\depers\\java.txt";
        // 创建具有指定操作的新 FilePermission 对象，path 是文件或目录的路径名，actions 包含对文件或目录授予的所需操作的列表，
        // 该列表由逗号分隔。可能的操作有 "read"、"write"、"execute" 和 "delete"。
        FilePermission file1 = new FilePermission("D:\\depers\\-", "read");
        // 返回一个新的PermissionCollection对象，用于存储FilePermission对象。
        PermissionCollection permission = file1.newPermissionCollection();
        // 添加权限
        permission.add(file1);
        FilePermission file2 = new FilePermission(srg, "write");
        permission.add(file2);

        // 它用于检查 FilePermission 对象是否具有指定的权限。
        if(permission.implies(new FilePermission(srg, "read,write"))) {
            System.out.println("Read, Write permission is granted for the path "+srg );
        }else {
            System.out.println("No Read, Write permission is granted for the path "+srg);            }
    }
}
