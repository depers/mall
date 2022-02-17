package cn.bravedawn.encrypt.keyexchange;

public class DHExample2 {

    /**
     * Diffie-Hellman算法的使用
     */

    public static void main(String[] args) {

        DiffieHellman bob = new DiffieHellman("Bob");
        DiffieHellman alice = new DiffieHellman("Alice");

        // 生成各自的keypair
        bob.generateKeyPair();
        alice.generateKeyPair();

        // 双方交换各自的publicKey
        // Bob根据Alice的publicKey生成自己的本地密钥
        bob.generateSecretKey(alice.publicKey.getEncoded());
        // Alice根据Bob的publicKey生成自己的本地密钥
        alice.generateSecretKey(bob.publicKey.getEncoded());

        // 检查双方的本地密钥是否相同
        bob.printKeys();
        alice.printKeys();
        // 双方的SecretKey相同，后续通信将使用SecretKey作为密钥进行AES加解密...
    }

}
