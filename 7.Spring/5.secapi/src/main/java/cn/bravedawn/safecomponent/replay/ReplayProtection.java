package cn.bravedawn.safecomponent.replay;

import cn.bravedawn.safecomponent.core.itfs.IReplayProtection;

/**
 * @Author : fengx9
 * @Project : secapi
 * @Date : Created in 2023-11-03 17:04
 */
public class ReplayProtection implements IReplayProtection {

    private static volatile ReplayProtection instance = null;



    public String generateToken(String data, long expiration) {
        return null;
    }

    public String verifyToken(String token) {
        return null;
    }
}
