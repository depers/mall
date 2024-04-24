package cn.bravedawn.exception.customexception;

/**
 * @Author : fengx9
 * @Project : 2.JavaTrain
 * @Date : Created in 2024-01-02 15:38
 */
public class CustomExceptionExample2 {

    /**
     * 对writableStackTrace参数的讨论，该字段用来标识是否记录产生该异常的堆栈位置
     */


    public static void main(String[] args) {
        CustomRuntimeException exception = new CustomRuntimeException("错误");
        exception.printStackTrace();

        CustomRuntimeException exception2 = new CustomRuntimeException("错误2", true);
        exception2.printStackTrace();
    }
}
