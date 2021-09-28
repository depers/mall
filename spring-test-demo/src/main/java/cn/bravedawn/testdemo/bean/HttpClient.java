package cn.bravedawn.testdemo.bean;

/**
 * @author : depers
 * @program : spring-test-demo
 * @description: 接口
 * @date : Created in 2021/9/24 15:15
 */
public interface HttpClient {


    int before();


    default int send() {
        int result = before();
        System.out.println("------------HttpClient-----------result=" + result);
        return result + 1;
    }

}
