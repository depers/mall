package cn.bravedawn.encrypt.digest.encrypted;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author : depers
 * @program : JavaTrain
 * @date : Created in 2024/7/12 23:05
 *
 * BCrypt算法的实现
 */
public class BcryptExample {

    public static void main(String[] args) {

        String encryptPwd = BCrypt.hashpw("123456", BCrypt.gensalt(12));
        System.out.println(encryptPwd);
        System.out.println(encryptPwd);
    }
}
