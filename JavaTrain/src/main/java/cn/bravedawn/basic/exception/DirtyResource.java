package cn.bravedawn.basic.exception;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: auto closeable resource
 * @date : Created in 2021/10/10 9:31
 */
public class DirtyResource implements AutoCloseable {
    /**
     * Need to call this method if you want to access this resource
     * @throws RuntimeException no matter how you call this method
     * */
    public void accessResource() {
        throw new RuntimeException("I wanted to access this resource. Bad luck. Its dirty resource !!!");
    }

    /**
     * The overridden closure method from AutoCloseable interface
     * @throws Exception which is thrown during closure of this dirty resource
     * */
    @Override
    public void close() throws Exception {
        throw new NullPointerException("Remember me. I am your worst nightmare !! I am Null pointer exception !!");
    }
}
