package cn.bravedawn;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {


    /**
     * subStringAfter方法的使用
     */
    @Test
    public void testStringSubStringAfter() {
        String str = "a1234";
        System.out.println(StringUtils.substringAfter(str, "a"));
    }

}
