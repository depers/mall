package cn.bravedawn.io.scanning;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScanSum {

    /**
     *
     * <p>ScanXan示例将所有输入标记视为简单的String值。Scanner还支持所有Java语言的基本类型(char除外)
     * 以及BigInteger和BigDecimal的令牌。此外，数值可以使用千位分隔符。</p>
     */


    public static void main(String[] args) throws IOException {

        Scanner s = null;
        double sum = 0;

        try {
            s = new Scanner(new BufferedReader(new FileReader("usnumbers.txt")));
            // 区域设置，因为千位分隔符和小数符号是特定于区域设置的。因此，如果我们没有指定扫描器应该使用美国地区，那么下面的示例将不能在所有地区正确工作。
            s.useLocale(Locale.US);

            while (s.hasNext()) {
                if (s.hasNextDouble()) {
                    double num = s.nextDouble();
                    sum += num;
                    System.out.println("num = " + num);
                } else {
                    s.next();
                }
            }
        } finally {
            s.close();
        }

        System.out.println(sum);
    }
}
