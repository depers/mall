package cn.bravedawn.encrypt;


import sun.security.jca.Providers;

import java.security.Provider;
import java.security.SecureRandom;
import java.util.List;

/**
 * @author : depers
 * @program : JavaTrain
 * @description: SecureRandom
 * @date : Created in 2021/11/30 18:44
 */
public class SecureRandomExample {

    public static void main(String[] args) {
        SecureRandom defaultRandom = new SecureRandom();
        List<Provider> providers = Providers.getProviderList().providers();
        System.out.println("defaultRandom algorithm = " + defaultRandom.getAlgorithm());

        for(Provider provider : providers) {
            for (Provider.Service s : provider.getServices()) {
                if (s.getType().equals("SecureRandom")) {
                    System.out.println(s.getAlgorithm());
                }
            }
        }

        System.out.println(System.getProperty("securerandom.drbg.config"));
    }
}
