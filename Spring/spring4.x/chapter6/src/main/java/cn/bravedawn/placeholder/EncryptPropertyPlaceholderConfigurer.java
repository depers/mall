package cn.bravedawn.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * @author : depers
 * @description :
 * @program : 1.spring4.x
 * @date : Created in 2023/9/17 17:27
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {


    private String[] encryptNames = {"userName", "password"};


    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if (isEncryptProp(propertyName)) {
            String decryptValue = DESUtils.getDecryptString(propertyValue);
            System.out.println("解密后的字符串：" + decryptValue);
            return decryptValue;
        } else {
            return propertyValue;
        }
    }


    /**
     * 判断是否加密的属性
     * @param propertyName 属性名称
     * @return
     */
    private boolean isEncryptProp(String propertyName) {
        for (String encryptPropName : encryptNames) {
            if (encryptPropName.equals(propertyName)) {
                return true;
            }
        }
        return false;
    }
}
