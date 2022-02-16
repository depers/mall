package cn.bravedawn.encrypt.peb;

import javax.crypto.spec.PBEKeySpec;

public class PEBExample {


    public static void main(String[] args) {

    }

    // 加密口令，生产密钥key
    public static byte[] encrypt(String password, byte[] salt, byte[] input) {
        PBEKeySpec keySpec = new PBEKeySpec(password.toCharArray());
        return null;


    }
}
