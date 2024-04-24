package cn.bravedawn.exception;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CatchExample {

    /**
     * 多个catch语句只有一个能被执行
     */

    public static void main(String[] args) {

        try {
            //int i = 1 / 0;
            int[] a = {1};
            int b = a[1];
        } catch (ArithmeticException arithmeticException) {
            log.error("报除0异常");
            throw new RuntimeException("计算出错");
        } catch (Exception e) {
            log.error("报错了", e);
        }
    }
}
