package cn.bravedawn.enums;

/**
 * @author : depers
 * @program : mall
 * @description: redis key枚举
 * @date : Created in 2021/10/9 21:04
 */
public enum RedisKeyEnum {

    IDEMPOTENT_TOKEN_KEY("mall:redis:idempotent:token_%s", 60),
    ;

    private String key;

    private int expireTime;

    RedisKeyEnum(String key, int expireTime) {
        this.key = key;
        this.expireTime = expireTime;
    }

    public String getKey() {
        return key;
    }

    public int getExpireTime() {
        return expireTime;
    }
}
