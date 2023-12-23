package cn.bravedawn.io.bytestream;

import cn.bravedawn.io.utils.ResourceHelper;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2023-12-15 11:23
 */
public class SequenceInputStreamExample3 {

    /**
     * 如果我们需要从两个以上的文件中读取数据，则需要使用 Enumeration。枚举对象可以通过调用 Vector 类的 elements（） 方法获得。
     */

    public static void main(String[] args) throws IOException {
        //creating the FileInputStream objects for all the files
        FileInputStream fin = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/a.txt"));
        FileInputStream fin2 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/b.txt"));
        FileInputStream fin3 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/c.txt"));
        FileInputStream fin4 = new FileInputStream(ResourceHelper.getAbsoluteFilePath("doc/d.txt"));

        //creating Vector object to all the stream
        Vector v = new Vector();
        v.add(fin);
        v.add(fin2);
        v.add(fin3);
        v.add(fin4);

        //creating enumeration object by calling the elements method
        Enumeration e = v.elements();

        //passing the enumeration object in the constructor
        SequenceInputStream bin = new SequenceInputStream(e);
        int i = 0;
        while ((i = bin.read()) != -1) {
            System.out.print((char) i);
        }
        bin.close();
        fin.close();
        fin2.close();
    }
}
