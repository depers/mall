package cn.bravedawn.encrypt.keyexchange;

import javax.crypto.KeyAgreement;
import java.math.BigInteger;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;

public class DiffieHellman {


    /**
     * Diffie-Hellman算法的实现
     */

    public final String name;


    public PublicKey publicKey;
    private PrivateKey privateKey;
    private byte[] secretKey;

    public DiffieHellman(String name) {
        this.name = name;
    }


    public void generateKeyPair() {
        try {
            KeyPairGenerator kpGen = KeyPairGenerator.getInstance("DH");
            kpGen.initialize(512);
            KeyPair kp = kpGen.generateKeyPair();
            this.publicKey = kp.getPublic();
            this.privateKey = kp.getPrivate();

        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }
    }


    public void generateSecretKey(byte[] receivedPubKeyBytes) {
        try {
            // 从byte[]中恢复publicKey
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(receivedPubKeyBytes);
            KeyFactory kf = KeyFactory.getInstance("DH");
            PublicKey receivedPublicKey = kf.generatePublic(keySpec);

            // 生成本地密钥
            KeyAgreement keyAgreement = KeyAgreement.getInstance("DH");
            keyAgreement.init(this.privateKey);
            keyAgreement.doPhase(receivedPublicKey, true);

            // 生成SecretKey密钥
            this.secretKey = keyAgreement.generateSecret();
        } catch (GeneralSecurityException e) {
            throw new RuntimeException(e);
        }

    }

    public void printKeys() {
        System.out.printf("Name: %s\n", this.name);
        System.out.printf("Private key: %x\n", new BigInteger(1, this.privateKey.getEncoded()));
        System.out.printf("Public key: %x\n", new BigInteger(1, this.publicKey.getEncoded()));
        System.out.printf("Secret key: %x\n", new BigInteger(1, this.secretKey));
    }
}
