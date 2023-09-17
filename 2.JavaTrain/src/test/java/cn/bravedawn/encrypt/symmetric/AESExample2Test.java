package cn.bravedawn.encrypt.symmetric;

import cn.bravedawn.encrypt.symmetric.aes.AESExample2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Slf4j
public class AESExample2Test {


    @Test
    void givenPassword_whenEncrypt_thenSuccess()
            throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        // given
        String plainText = "www.baeldung.com";
        String password = "baeldung";
        String salt = "12345678";
        IvParameterSpec ivParameterSpec = AESExample2.generateIv();
        SecretKey key = AESExample2.getKeyFromPassword(password, salt, 128);

        // when
        String cipherText = AESExample2.encryptPasswordBased(plainText, key, ivParameterSpec);
        String decryptedCipherText = AESExample2.decryptPasswordBased(cipherText, key, ivParameterSpec);

        // then
        log.info("plainText={}, cipherText={}.", plainText, cipherText);

        Assertions.assertEquals(plainText, decryptedCipherText);
    }


    @Test
    void verify_different_salt_decryptFailure()
            throws InvalidKeySpecException, NoSuchAlgorithmException, IllegalBlockSizeException,
            InvalidKeyException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException {
        // given
        String plainText = "www.baeldung.com";
        String password = "baeldung";
        String salt = "12345678";
        IvParameterSpec ivParameterSpec = AESExample2.generateIv();
        SecretKey key = AESExample2.getKeyFromPassword(password, salt, 128);

        String cipherText = AESExample2.encryptPasswordBased(plainText, key, ivParameterSpec);

        String salt2 = "123456789";
        SecretKey key2 = AESExample2.getKeyFromPassword(password, salt2, 128);
        BadPaddingException badPaddingException = Assertions.assertThrows(BadPaddingException.class, () -> {
            String decryptedCipherText = AESExample2.decryptPasswordBased(cipherText, key2, ivParameterSpec);
            log.info("plainText={}, cipherText={}, decryptedCipherText={}.", plainText, cipherText, decryptedCipherText);
        });



    }
}
