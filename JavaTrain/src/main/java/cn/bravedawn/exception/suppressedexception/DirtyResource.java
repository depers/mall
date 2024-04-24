package cn.bravedawn.exception.suppressedexception;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: auto closeable resource
 * @date : Created in 2021/10/10 9:31
 */
public class DirtyResource implements AutoCloseable {

    /**
     * 访问资源
     * @throws RuntimeException 运行时异常
     * */
    public void accessResource() {
        throw new RuntimeException("我想访问这个资源，不幸的是他是脏数据！！！");
    }


    /**
     * 覆写AutoCloseable interface的close方法
     * @throws Exception 检查异常
     * */
    @Override
    public void close() throws Exception {
        throw new NullPointerException("关闭资源的时候，会抛出空指针!!");
    }
}
