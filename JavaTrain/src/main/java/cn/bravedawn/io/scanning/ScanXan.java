package cn.bravedawn.io.scanning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanXan {

    /**
     * <p>Scanner 类型的对象有助于将格式化的输入分解为标记，并根据标记的数据类型转换单个标记。</p>
     * <p>Scanner会按照分割符拆分数据，并按照数据类型将其转换为单个的数据标记。</p>
     * 默认情况下，扫描器使用空白来分隔令牌。(空格字符包括空格、制表符和行结束符。有关完整列表，请参阅{@link Character#isWhitespace(char)}的文档。)
     */

    public static void main(String[] args) throws IOException {

        Scanner s = null;

        try {
            s = new Scanner(new BufferedReader(new FileReader("xanadu.txt")));
            // 设置分隔符
            s.useDelimiter(",\\s*");

            while (s.hasNext()) {
                System.out.println(s.next());
            }
        } finally {
            if (s != null) {
                s.close();
            }
        }
    }

}
