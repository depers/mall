package cn.bravedawn.safecomponent.core.itfs;

/**
 * @Author : fengx9
 * @Project : secapi
 * @Date : Created in 2023-11-03 16:59
 */
public interface IReplayProtection {

    /**
     * 生成Token
     * @param data 数据
     * @param expiration 有效时间，单位：毫秒
     * @return token
     */
    String generateToken(String data, long expiration);


    /**
     * 校验token
     * @param token
     * @return 原报文字符串
     */
    String verifyToken(String token);
}
