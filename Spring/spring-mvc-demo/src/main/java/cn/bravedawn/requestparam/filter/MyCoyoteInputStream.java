package cn.bravedawn.requestparam.filter;

import org.apache.catalina.connector.CoyoteInputStream;
import org.apache.catalina.connector.InputBuffer;

/**
 * @author : depers
 * @program : spring-mvc-demo
 * @date : Created in 2024/8/2 15:06
 */
public class MyCoyoteInputStream extends CoyoteInputStream {


    protected MyCoyoteInputStream(InputBuffer ib) {
        super(ib);
    }
}
